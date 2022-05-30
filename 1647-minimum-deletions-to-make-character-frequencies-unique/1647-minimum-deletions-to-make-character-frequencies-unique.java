class Solution {
    public int minDeletions(String s) {
        
        char[]arr = s.toCharArray();
        Arrays.sort(arr);
        int ans = 0, i=0;
        
        Set<Integer>hs = new HashSet<>();
        while(i<arr.length){
            int occ = 0;
            char og = arr[i];
            while(i<arr.length && arr[i]==og) {
                i++;
                occ++;
            }
            
            while(occ>0 && hs.contains(occ)){
                ans++;
                occ--;
            }
            hs.add(occ);
        }
        return ans;
    }
}