package com.study.xyl._24_Code;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] sourceArray = {4, 2, 9, 3, 8, 1, 7};
        int[] ints = mergeSoft(sourceArray);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] mergeSoft(int[] sourceArray) {
        if (sourceArray == null || sourceArray.length < 2) {
            return sourceArray;
        }

        int length = sourceArray.length;
        int[] array = Arrays.copyOf(sourceArray, length);
        process(array, 0, length - 1);
        return array;
    }

    public static void process(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        process(array, left, mid);
        process(array, mid + 1, right);
        partition(array, left, mid, right);
    }

    public static void partition(int[] array, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            help[index++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }

        while (p1 <= mid) {
            help[index++] = array[p1++];
        }

        while (p2 <= right) {
            help[index++] = array[p2++];
        }

        System.arraycopy(help, 0, array, left, help.length);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
