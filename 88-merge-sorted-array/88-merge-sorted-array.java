class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length-1;
        while(m >= 1 && n >= 1){
            if(nums1[m-1] >= nums2[n-1]){
                nums1[i--] = nums1[m-- -1];
            }
            else nums1[i--] = nums2[n-- -1];
        }
        while(m!=0){
            nums1[i--] = nums1[m-- -1];
        }
        while(n!=0){
            nums1[i--] = nums2[n-- -1];
        }
    }
}