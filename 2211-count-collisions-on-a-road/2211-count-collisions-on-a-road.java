class Solution {
    public int countCollisions(String s) {
        if(s.length() == 1) return 0;
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for(int i=1; i<sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch == 'L' && sb.charAt(i-1) == 'R'){
                int temp = 0, idx=i-1;
                while(idx>=0 && sb.charAt(idx--)=='R') temp++;
                count += temp + 1;
                sb.setCharAt(i-1, 'S');
                sb.setCharAt(i, 'S');
            }
            else if(ch == 'L' && sb.charAt(i-1) == 'S'){
                count += 1;
                sb.setCharAt(i, 'S');
            }
            else if(ch == 'S' && sb.charAt(i-1) == 'R'){
                int temp = 0, idx = i-1;
                while(idx>=0 && sb.charAt(idx--)=='R') temp++;
                count += temp;
                sb.setCharAt(i-1, 'S');
            }
        }
        return count;
    }
}