package basic;

public class Sort {
    public void quicSort(int[] nums){
        if(nums.length == 0 || nums.length == 1) {
            return;
        }

        int pos = partition(nums, 0, nums.length-1);
        partition(nums, 0, pos - 1);
        partition(nums, pos  + 1, nums.length - 1);

    }

    public int partition(int[] nums, int start, int end){
        if(start == end)
            return start;

        int num = nums[end];
        int j = start - 1;
        for(int i = start ; i < end; i++){
            if(nums[i] >= num){
                continue;
            } else {
                j++;
                swap(nums, i, j);

            }
        }

        swap(nums, ++j, end);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] nums = {1,2,3,4,5,2,3};
        sort.quicSort(nums);
        System.out.println(nums);

    }

}
