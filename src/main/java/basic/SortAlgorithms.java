package basic;

import java.util.Arrays;

public class SortAlgorithms {
    //描述：类似于我们整理扑克牌的方法，逐步将元素插入到已排序部分的适当位置。
    public static void insertSort(int[] nums){
        for(int i=1; i<nums.length; i++){
            int cur = i;
            for(int j=i-1; j>=0; j--){
                if(nums[cur] < nums[j]){
                    int tmp = nums[cur];
                    nums[cur] = nums[j];
                    nums[j] = tmp;
                    cur = j;
                }else
                    break;
            }
        }
    }

    public static void insertSort2(int[] nums){
        for(int i=1; i<nums.length; i++){
            int key = nums[i];
            int j = i-1;
            while(j >= 0 && key < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,44,5,6};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums){
        if(nums == null)
            return;
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int low, int high){
        if(low >= high)
            return;
        int index = partition(nums, low, high);

        quickSort(nums, low, index-1);
        quickSort(nums, index+1, high);
    }

    static int partition(int[] nums, int low, int high){
        int key = nums[high];
        int j = low-1;
        for(int i=low; i< high; i++){
            if(nums[i] < key){
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j+1, high);

        return j+1;
    }

    static void swap(int[] nums, int i, int j){
        if(i==j)
            return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void selectionSort(int[] nums){
        for(int i=0; i< nums.length; i++){
            int min = nums[i];
            int minIndex = i;
            for(int j = i; j< nums.length; j++){
                if(min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public static void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
    }

    public static void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 复制数据到临时数组
        for (int i = 0; i < n1; i++) leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // 归并两个有序子数组
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 复制剩余元素（如果有）
        while (i < n1) arr[k++] = leftArray[i++];
        while (j < n2) arr[k++] = rightArray[j++];
    }

    public static void bubbleSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j< nums.length - i-1; j++){
                if(nums[j] > nums[j +1]){
                    swap(nums, j, j+1);
                }
            }
        }
    }

    //root = n;
    //left = 2n+1;
    //right = 2n+2;

    public static void heapSort(int[] nums){
        int n = nums.length;
        for(int i= nums.length/2-1; i >=0; i--){
            heapify(nums,nums.length, i);
        }

        for (int j=n-1; j>=0; j--){
            swap(nums, 0, j);
            heapify(nums, j, 0);
        }
    }

    public static void heapify(int[] nums, int end ,int root) {
        int left = root*2+1;
        int right = root*2+2;
        int largest = root;
        if(left < end && nums[left] > nums[root]) {
            largest = left;
        }

        if(right < end && nums[right] > nums[root]){
            largest = right;
        }

        if(largest != root){
            swap(nums, largest, root);
            heapify(nums, end, largest);
        }
    }
}
