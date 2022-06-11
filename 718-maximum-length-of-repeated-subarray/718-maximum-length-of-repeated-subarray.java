// Similar to Longest Common Substring Tabulation
// Only difference is we return 0 if consecutive characters are not present

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][]dp = new int[nums1.length+1][nums2.length+1];
        int max = 0;
        for(int i=nums1.length; i>=0; i--){
            for(int j=nums2.length; j>=0; j--){
                if(!(i == nums1.length || j == nums2.length) && nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}