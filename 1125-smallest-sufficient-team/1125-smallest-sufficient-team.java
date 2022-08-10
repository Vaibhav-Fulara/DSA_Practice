// Recursion TLE
// O(2^n)

class Solution {
    int[]ans = new int[61];
    public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        HashMap<String, Integer>hm = new HashMap<>();
        int i=0, m = people.size();
        for(String s:skills) hm.put(s, i++);
        
        int[]arr = new int[people.size()];
        
        i=0;
        for(List<String>al:people) {
            int bitmask = 0;
            for(String s:al) {
                int mask = 1 << (hm.get(s));
                bitmask |= mask;
            }
            arr[i++] = bitmask;
        }
        
        boolean[] redundant = new boolean[m];
        for (i = 0; i < m; i ++) {
            for (int j = i + 1; j < m; j ++) {
                int val = arr[i] | arr[j];
                if (val == arr[i]) {
                    redundant[j] = true;
                } else if (val == arr[j]) {
                    redundant[i] = true;
                }
            }
        }
        
        List<Integer>al = new ArrayList<>();
        solve(skills, arr, 0, 0, al, redundant);
        return ans;
    }
    
    public void solve(String[]skills, int[]arr, int i, int curr, List<Integer>al, boolean[]red) {
        
        if(i == arr.length) {
            if(curr == (int)Math.pow(2, skills.length)-1) {
                if(ans.length > al.size()) {
                    ans = new int[al.size()];
                    int j=0;
                    for(int val:al) ans[j++] = val;
                }
            }
            return;
        }
        
        if(al.size() > ans.length) return;
        
        solve(skills, arr, i+1, curr, al, red);
        if(!red[i]) {
            al.add(i);
            solve(skills, arr, i+1, curr | arr[i], al, red);
            al.remove(al.size()-1);
        }
    }
}