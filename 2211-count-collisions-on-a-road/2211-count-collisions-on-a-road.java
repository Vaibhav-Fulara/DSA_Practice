class Solution {
    public int countCollisions(String s) {
        if(s.length() == 1) return 0;
        StringBuilder sb = new StringBuilder(s);
        int count = 0, rmoves = 0;
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            if(i==0){
                if(ch=='R') rmoves++;
                continue;
            } 
            
            if(ch=='R') rmoves++;
            
            else if(sb.charAt(i-1) != 'R') rmoves =0;
            if(ch == 'L' && sb.charAt(i-1) == 'R'){
                count += rmoves + 1;
                rmoves = 0;
                sb.setCharAt(i-1, 'S');
                sb.setCharAt(i, 'S');
            }
            else if(ch == 'L' && sb.charAt(i-1) == 'S'){
                count += 1;
                sb.setCharAt(i, 'S');
            }
            else if(ch == 'S' && sb.charAt(i-1) == 'R'){
                count += rmoves;
                rmoves = 0;
                sb.setCharAt(i-1, 'S');
            }
        }
        return count;
    }
}