package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 11/12/2017 11:58 PM
 */
public class NO88_MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length==0||nums2.length==0)
            return;
        int length = m+n;
        int[] ans = new int[length];
        int i1=0;
        int i2=0;
        for(int i=0;i<length;i++){
            if(i1==m){
                ans[i]=nums2[i2++];
            }else if(i2==n){
                ans[i]=nums1[i1++];
            }else if(nums1[i1]<=nums2[i2]){
                ans[i]=nums1[i1++];
            }else{
                ans[i]=nums2[i2++];
            }
        }
        for(int i=0;i<length;i++){
            nums1[i]=ans[i];
        }
    }



    public static void main(String[] args){
        int[] nums1={1,2,3,0,0,0,0,0};
        int[] nums2={1,2,3,3,4};
        NO88_MergeTwoSortedArray mergeTwoSortedArray = new NO88_MergeTwoSortedArray();
        mergeTwoSortedArray.merge(nums1,3,nums2,5);
    }
}
