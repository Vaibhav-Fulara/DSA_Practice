class Solution {
    public boolean checkPossibility(int[]arr) {
        int idx = check(arr);
        if (idx == -1) return true;
        int t1 = arr[idx], t2 = arr[idx+1];
        
        arr[idx] = t2;
        int v1 = check(arr);
        arr[idx] = t1;
        
        arr[idx+1] = t1;
        int v2 = check(arr);
        
        return v1 == -1 || v2 == -1;
    }
    
    public int check(int[]arr){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]) return i;
        }
        return -1;
    }
}