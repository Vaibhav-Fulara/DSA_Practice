class Solution {
    public int minimumMountainRemovals(int[]arr) {
        return arr.length - getLargestBitonic(arr);
    }
    public int getLargestBitonic(int[]arr){
        int[]front = new int[arr.length];
        int[]back = new int[arr.length];
        Arrays.fill(front, 1);
        Arrays.fill(back, 1);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && front[j]+1 > front[i]){
                    front[i] = front[j] + 1;
                }
            }
        }
        
        for(int i=arr.length-1; i>=0; i--){
            for(int j=arr.length-1; j>i; j--){
                if(arr[i] > arr[j] && back[j] + 1 > back[i]){
                    back[i] = back[j]+1;
                }
            }
        }
        
        int max = 1;
        for(int i=1; i<arr.length-1; i++) if(front[i] > 1 && back[i] > 1) max = Math.max(max, front[i]+back[i]-1);
        return max;
    }
}