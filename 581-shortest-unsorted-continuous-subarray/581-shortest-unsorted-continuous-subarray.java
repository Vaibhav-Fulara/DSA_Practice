class Solution {
    public int findUnsortedSubarray(int[]arr) {
        int strt, end, min, max, count = 0;
        strt = end = max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            if(arr[i]<arr[i-1]){
                if(strt>=0) end = i;
                else {strt = i-1; end = i;}
            }
        }
        if(strt>=0){
            for(int i=strt; i<=end; i++){
                if(arr[i]>max) max = arr[i];
                if(arr[i]<min) min = arr[i];
            }
            count = end-strt+1;
            for(int i=0; i<strt; i++) if(arr[i]>min) count++;
            for(int i=end+1; i<arr.length; i++) if(arr[i]<max) count++;
        }
        return count;
    }
}