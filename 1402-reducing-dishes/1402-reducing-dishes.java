class Solution {
    public int maxSatisfaction(int[]arr) {
        int max = 0;
        boolean flag = false;
        
        Arrays.sort(arr);
        
        int sum = 0, curr = 0;
        for(int i=arr.length-1; i>=0; i--){
            curr += arr[i];
            sum += curr;
            if(max < sum) max = sum;
            else break;
        }
        return max;
    }
}