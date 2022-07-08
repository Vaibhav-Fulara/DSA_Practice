class Solution {
    public String crackSafe(int n, int k) {
        Set<String>hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append('0');
        hs.add(sb.toString());
        dfs(sb, hs, (int)Math.pow(k,n), n, k);
        return sb.toString();
    }
    public boolean dfs(StringBuilder sb, Set<String>hs, int lim, int n, int k){
        if(hs.size() == lim) return true;
        
        String preString = sb.substring(sb.length() - (n-1)); // last (n-1) chars
        for(int i=0; i<k; i++){
            String newPassword = preString+i;
            if(!hs.contains(newPassword)){
                hs.add(newPassword);
                sb.append(i);
                boolean flag = dfs(sb, hs, lim, n, k);
                if(flag) return true;
                hs.remove(newPassword);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}