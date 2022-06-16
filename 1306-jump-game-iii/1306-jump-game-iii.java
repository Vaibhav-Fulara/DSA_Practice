class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer>hs = new HashSet<>();
        return getPath(arr, start, hs);
    }
    public boolean getPath(int[]arr, int i, Set<Integer>hs){
        if(arr[i] == 0) return true;
        if(hs.contains(i)) return false;
        
        hs.add(i);
        if(i-arr[i] >= 0 && getPath(arr, i-arr[i], hs)) return true;
        if(i+arr[i] < arr.length && getPath(arr, i+arr[i], hs)) return true;
        hs.remove(i);
        
        return false;
    }
}