class Solution {
    public int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int n = arr1.length, count = 0;
        
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<n; i++) hm.put(arr4[i], hm.getOrDefault(arr4[i], 0)+1);
        HashMap<Integer, Integer>hm1 = new HashMap<>();
        for(int val:hm.keySet()) for(int i=0; i<n; i++) hm1.put(val + arr3[i], hm1.getOrDefault(arr3[i] + val, 0)+hm.get(val));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int sum = arr1[i] + arr2[j];
                count += hm1.getOrDefault(-sum, 0);
            }
        }
        
        return count;
    }
}