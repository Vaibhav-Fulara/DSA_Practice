class Solution {
    public int minimumBuckets(String street) {
        StringBuilder str = new StringBuilder(street);
        if(str.length()==1){
            if(str.charAt(0)=='H') return -1; 
            return 0;
        }
        int ans = 0;
        if(str.charAt(0)=='H') {
            if(str.length()>1 && str.charAt(1)== '.') str.setCharAt(1, 'W');
            ans++;
        }
        if(str.charAt(1) == 'H'){
            if(str.charAt(0) == 'H') return -1;
            if(str.length()>2 && str.charAt(2)== '.') str.setCharAt(2, 'W');
            ans++;
        }
        
        for(int i=2; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch=='H'){
                char prev1 = str.charAt(i-1);
                char prev2 = str.charAt(i-2);
                char next = 'H';
                if(i != str.length()-1) next = str.charAt(i+1);
                if(prev1 == 'H'){
                    if(i==str.length()-1 || str.charAt(i+1)=='H') return -1;
                    if(next== '.') str.setCharAt(i+1, 'W');
                    ans++;
                }
                else if(prev2 == '.' || prev2 == 'W') {
                    if(next== '.') str.setCharAt(i+1, 'W');
                    else str.setCharAt(i-1,'W');
                    ans++;
                }
                else if(prev2 == 'H') {
                    if(prev1 == '.'){
                        if(next== '.') str.setCharAt(i+1, 'W');
                        else str.setCharAt(i-1,'W');
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}