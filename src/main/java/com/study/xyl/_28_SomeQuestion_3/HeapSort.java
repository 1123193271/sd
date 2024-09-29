package com.study.xyl._28_SomeQuestion_3;

/**
 * @author 11231
 * @date 2024/9/25 11:02
 */
public class HeapSort {

    public int[] heapSort(int[] nums) {
        int length = nums.length;
        for (int i = (length - 2) / 2; i >= 0; i--) {
            downAdjust(nums, i, length - 1);
        }
        //进行堆排序
        for (int i = length - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性
            downAdjust(nums, 0, i - 1);
        }
        return nums;
    }

    public static void downAdjust(int[] nums, int parent, int n){
        //临时保存要下沉的元素
        int temp = nums[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if(child + 1 <= n && nums[child] < nums[child + 1])
                child++;
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (nums[child] <= temp ) break;
            //否则父节点下沉
            nums[parent] = nums[child];

            parent = child;
            child = 2 * parent + 1;
        }
        nums[parent] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(new int[]{3,4,6,1,2,4,76,8,3,22});
    }
}
