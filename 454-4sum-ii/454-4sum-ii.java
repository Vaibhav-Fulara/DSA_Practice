class Solution {
    public int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int n = arr1.length, count = 0;
        
        HashMap<Integer, Integer>hm = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int sum = arr3[i] + arr4[j];
                hm.put(sum, hm.getOrDefault(sum, 0)+1);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int sum = arr1[i] + arr2[j];
                count += hm.getOrDefault(-sum, 0);
            }
        }
        
        return count;
    }
}