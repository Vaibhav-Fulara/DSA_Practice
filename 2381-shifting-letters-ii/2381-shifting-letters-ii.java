class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[]arr = new int[s.length()];
        for(int[]shift:shifts) {
            int tar = (shift[2] == 1 ? 1:-1);
            arr[shift[0]] += tar;
            if(shift[1] + 1 < arr.length) arr[shift[1] + 1] -= tar;
        }
        
        int comp1 = 'a';
        int comp2 = 'z';
        
        StringBuilder sb = new StringBuilder(s);
        int pre = 0;
        for(int i=0; i<arr.length; i++) {
            pre = (pre + arr[i]) % 26;
            int tar = s.charAt(i) + pre;
            if(tar > comp2) {               // Exceeds 'Z'
                tar -= 26;
                sb.setCharAt(i, (char)(tar));
            } else if(tar < comp1) {        // Lower than 'A'
                tar += 26;
                sb.setCharAt(i, (char)(tar));
            } else {
                sb.setCharAt(i, (char)tar);
            }
        }
        return sb.toString();
    }
}