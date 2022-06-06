class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int)1e9+7;
        Arrays.sort(arr);
        long ans = 0;
        
        Map<Integer, Long>hm = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            long count = 1;
            for(int j=0; j < i; j++){
                if(arr[i] % arr[j] == 0 && hm.containsKey(arr[i]/arr[j])) {
                    count += hm.get(arr[j])*hm.get(arr[i]/arr[j]);
                }
            }
            hm.put(arr[i], count);
        }
        for(int val:hm.keySet()){
            ans += hm.get(val);
            ans %= mod;
        }
        return (int)ans;
    }
}