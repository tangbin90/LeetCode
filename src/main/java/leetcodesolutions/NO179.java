package leetcodesolutions;

public class NO179 {
    public String largestNumber(int[] nums) {
        //digit number from low to high, digit from high to low
        StringBuilder sb = new StringBuilder();
        quickSort(nums);

        for(int num: nums){
            sb.append(String.valueOf(num));
        }
        int zeroIndex= 0;
        while(sb.charAt(zeroIndex)=='0' && zeroIndex < sb.length()-1){
            zeroIndex++;
        }
        return sb.substring(zeroIndex);

    }

    public void quickSort(int[] nums){
        if(nums == null)
            return;
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] nums, int low, int high){
        if(low >= high)
            return;
        int index = partition(nums, low, high);

        quickSort(nums, low, index-1);
        quickSort(nums, index+1, high);
    }

    public int partition(int[] nums, int low, int high){
        int key = nums[high];
        int j = low-1;
        for(int i=low; i< high; i++){
            if(abeforeb(nums[i], key)){
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j+1, high);

        return j+1;
    }

    public void swap(int[] nums, int i, int j){
        if(i==j)
            return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public boolean abeforeb(int a, int b){
        String astr = String.valueOf(a);
        String bstr = String.valueOf(b);
        String ab = astr + bstr;
        String ba = bstr + astr;
        int tmp = 0;
        while(tmp < ab.length()){
            if(ab.charAt(tmp) > ba.charAt(tmp))
                return true;
            else if(ab.charAt(tmp) < ba.charAt(tmp))
                return false;
            else tmp++;
        }
        return true;
    }
}
