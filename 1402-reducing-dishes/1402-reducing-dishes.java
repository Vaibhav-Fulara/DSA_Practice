class Solution {
    public int maxSatisfaction(int[]arr) {
        int max = 0;
        boolean flag = false;
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 0) {
                if(flag) break;
                else flag = true;
            }
            
            int j = 1, curr = 0;
            for(int k=i; k<arr.length; k++){
                curr += arr[k]*j;
                j++;
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}