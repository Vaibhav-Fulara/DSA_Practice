class Solution {
    public int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int n = arr1.length, count = 0, sum = 0;
        
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<n; i++) hm.put(arr4[i], hm.getOrDefault(arr4[i], 0)+1);
        HashMap<Integer, Integer>hm1 = new HashMap<>();
        for(int val:hm.keySet()) for(int i=0; i<n; i++) hm1.put(val + arr3[i], hm1.getOrDefault(arr3[i] + val, 0)+hm.get(val));
        HashMap<Integer, Integer>hm2 = new HashMap<>();
        for(int val:hm1.keySet()) for(int i=0; i<n; i++) hm2.put(val + arr2[i], hm2.getOrDefault(arr2[i] + val, 0)+hm1.get(val));
        HashMap<Integer, Integer>hm3 = new HashMap<>();
        for(int val:hm2.keySet()) for(int i=0; i<n; i++) hm3.put(val + arr1[i], hm3.getOrDefault(arr1[i] + val, 0)+hm2.get(val));
        
        return hm3.getOrDefault(0,0);
    }
}