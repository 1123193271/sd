package com.study.xyl._26_algorithm;

import java.util.*;

/**
 * @author 11231
 * @date 2024/9/9 17:02
 */
public class OpenLock {
    private static final String[] deadens = {"5000", "5680", "1000"};

    public static String plusOne(String s, int position) {
        char[] charArray = s.toCharArray();
        if (charArray[position] == '9') {
            charArray[position] = '0';
        } else {
            charArray[position] += 1;
        }
        return new String(charArray);
    }


    public static String minusOne(String s, int position) {
        char[] charArray = s.toCharArray();
        if (charArray[position] == '0') {
            charArray[position] = '9';
        } else {
            charArray[position] -= 1;
        }
        return new String(charArray);
    }

    //广度优先
    public static int BFS(String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> notAllowed = new HashSet<>(Arrays.asList(deadens));
        Set<String> visited = new HashSet<>();
        //从0000开始
        q.offer("0000");
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                assert cur != null;

                if (notAllowed.contains(cur))
                    continue;
                if (cur.equals(target)) {
                    //密码出来了
                    System.out.println(cur);
                    return depth;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            depth ++;
        }
        return -1;
    }

    public static int BFS_List(String target) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> notAllowed = new HashSet<>(Arrays.asList(deadens));
        Set<String> visited = new HashSet<>();
        //从0000开始
        q.offer(Collections.singletonList("0000"));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<String> cur = q.poll();
                assert cur != null;

                String curString = cur.get(cur.size() - 1);
                if (notAllowed.contains(cur.get(cur.size()-1)))
                    continue;
                if (curString.equals(target)) {
                    //密码出来了
                    System.out.println(Arrays.toString(cur.toArray()));
//                    return depth;
                    return cur.size();
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curString, j);
                    String down = minusOne(curString, j);
                    if (!visited.contains(up)) {
                        List<String> upList = new ArrayList<>(cur);
                        upList.add(up);
                        q.offer(upList);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        List<String> downList = new ArrayList<>(cur);
                        downList.add(down);
                        q.offer(downList);
                        visited.add(down);
                    }
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String target = "5679";
//        System.out.println(BFS(target));
        System.out.println(BFS_List(target));
        //额外拓展
    }

}
