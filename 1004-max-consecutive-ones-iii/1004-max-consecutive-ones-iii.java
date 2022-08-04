class Solution {
    public int longestOnes(int[] arr, int k) {
        int i=0, j=0;
        int max = 0, curr = 0;
        
        while(j < arr.length) {
            if(arr[j] == 0) {
                if (curr < k) {
                    curr++;
                } else {
                    max = Math.max(j-i, max);
                    while(arr[i++] != 0);
                }
            }
            j++;
        }
        max = Math.max(j-i, max);
        return max;
    }
}