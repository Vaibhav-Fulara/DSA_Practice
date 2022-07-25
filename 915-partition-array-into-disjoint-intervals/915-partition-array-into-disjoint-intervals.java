class Solution {
    public int partitionDisjoint(int[]arr) {
        int n = arr.length;
        int[]smolFromRight = new int[n];
        int[]bigFromLeft = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int part = n-1;
        
        for(int i=0; i<arr.length; i++){
            bigFromLeft[i] = Math.max(max, arr[i]);
            smolFromRight[n-i-1] = Math.min(min, arr[n-i-1]);
            min = Math.min(min, arr[n-i-1]);
            max = Math.max(max, arr[i]);
        }
        
        // for(int i=0; i<arr.length; i++) {
        //     System.out.println(bigFromLeft[i] +" "+smolFromRight[i]);
        // }
        
        for(int i=0; i<arr.length-1; i++) {
            if(bigFromLeft[i] <= smolFromRight[i+1]) {
                part = i+1;
                break;
            }
        }
        
        return part;
    }
}