package com.study.xyl._28_SomeQuestion_3;

/**
 * @author 11231
 * @date 2024/9/24 16:29
 */
public class ShellSort {
    public  int[] shellSort(int arr[]) {
        if (arr == null || arr.length < 2) return arr;
        int n = arr.length;
        // 对每组间隔为 h的分组进行排序，刚开始 h = n / 2;
        for (int h = n / 2; h > 0; h /= 2) {
            //对各个局部分组进行插入排序
            for (int i = h; i < n; i++) {
                // 将arr[i] 插入到所在分组的正确位置上
                insertI(arr, h, i);
            }
        }
        return arr;
    }

    /**
     * 将arr[i]插入到所在分组的正确位置上
     * arr[i]] 所在的分组为 ... arr[i-2*h],arr[i-h], arr[i+h] ...
     */
    private  void insertI(int[] arr, int h, int i) {
        int temp = arr[i];
        int k;
        for (k = i - h; k >= 0 && temp < arr[k]; k -= h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }
}
