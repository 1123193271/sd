package com.study.xyl._27_leecCode;

/**
 * @author 11231
 * @date 2024/9/12 18:22
 */
public class Q_1071 {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int a = Math.min(len1, len2);
        while (a > 0) {
            if (len1 % a > 0 || len2 % a > 0) {
                a--;
                continue;
            }
            if (checkIsOfStrings(str1,str1.substring(0,a)) &&
                    checkIsOfStrings(str2,str1.substring(0,a))) {
                return str1.substring(0,a);
            } else {
                a--;
            }
        }
        return str1.substring(0,a);
    }
     public boolean checkIsOfStrings(String str, String template) {
         for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != template.charAt(i%template.length())) {
                return false;
            }
         }
        return true;
     }

    public static void main(String[] args) {
        Q_1071 q1071 = new Q_1071();
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(q1071.gcdOfStrings(str1, str2));
    }
}
