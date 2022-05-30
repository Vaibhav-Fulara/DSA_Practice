class Solution {
    public int minimumDeletions(int[]arr) {
        if(arr.length < 3) return arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minidx = 0, maxidx = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>max) {
                max = arr[i];
                maxidx = i;
            }
            if(arr[i]<min) {
                min = arr[i];
                minidx = i;
            }
        }
        int big = Math.max(minidx, maxidx);
        int smol = Math.min(minidx, maxidx);
        int ans = 0;
        if(arr.length - big > smol + 1) return smol + 1 + Math.min(arr.length-big, big - smol);
        else return arr.length-big + Math.min(smol + 1, big - smol);
    }
}