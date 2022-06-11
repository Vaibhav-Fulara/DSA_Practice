class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long tar) {
        Arrays.sort(potions);
        int[]arr = new int[spells.length];
        for(int i=0; i<spells.length; i++){
            long val = spells[i];
            int s = search(potions, 0, potions.length, tar, (long)spells[i]);
            arr[i] = potions.length - s;
        }
        return arr;
    }
    public int search(int[]arr, int lo, int hi, long tar, long i){
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]*i == tar) hi = mid;
            else if(arr[mid]*i > tar) hi = mid;
            else lo = mid+1;
        }
        return hi;
    }
}