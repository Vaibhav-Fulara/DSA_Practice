// O(n)
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer>hm = new HashMap<>();
        for(int val:arr) hm.put(val, hm.getOrDefault(val, 0) + 1);
        
        int[]a = new int[(int)1e5];
        for(int val:hm.keySet()) a[hm.get(val)]++;
        
        int ans = 0;
        int sum = 0;
        for(int i=a.length-1; i >= 0; i--) {
            while(a[i] != 0 && sum < arr.length/2) {
                sum += i;
                a[i]--;
                ans++;
            }
            if(sum >= arr.length/2) return ans;
        }
        return -1;
    }
}