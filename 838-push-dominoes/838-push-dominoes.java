class Solution {
    public String pushDominoes(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, 'L');
        sb.append('R');
        int prev = 0;
        char ch1 = 'L';
        for(int i=1; i<sb.length(); i++) {
            if(sb.charAt(i) != '.') {
                char ch2 = sb.charAt(i);
                if(ch1 == ch2) {
                    for(int j = prev+1; j<i; j++) {
                        sb.setCharAt(j, ch1);
                    }
                } else if (ch1 == 'R' && ch2 == 'L') {
                    int temp = i-1;
                    prev++;
                    while(temp > prev) {
                        sb.setCharAt(prev++, ch1);
                        sb.setCharAt(temp--, ch2);
                    }
                }
                // System.out.println(ch1 +" "+ ch2 +" "+ i);
                ch1 = ch2;
                prev = i;
            }
        }
        
        return sb.substring(1,sb.length()-1).toString();
    }
}