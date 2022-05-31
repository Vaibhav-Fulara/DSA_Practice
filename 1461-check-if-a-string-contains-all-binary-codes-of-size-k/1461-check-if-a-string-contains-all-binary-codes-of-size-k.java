class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length(), count = 0;
        if(k>n || s.length()<2) return false;
        Set<Integer>hs = new HashSet<>();
        for(int i=0; i<n; i++){
            if(i+k <= n){
                String str = s.substring(i, i+k);
                int num = binToDeci(str);

                if(!hs.contains(num)) count++;
                // System.out.println(num +" "+no+" "+i+ " "+count);

                hs.add(num);
                if(count == Math.pow(2,k)) return true;
            }
        }
        return false;
    }
    public int binToDeci(String s){
        int ans = 0;
        int mul = 1, i=s.length()-1;
        
        while(i != -1){
            if(s.charAt(i) == '1') ans += mul;
            mul *= 2;
            i--;
        }
        return ans;
    }
}