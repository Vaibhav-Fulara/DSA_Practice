class Solution {
    static Map<Integer, String>hm = new HashMap<>();
    public String countAndSay(int n) {
        hm.put(1, "1");
        if(hm.containsKey(n)) return hm.get(n);
        String s = countAndSay(n-1);
        String str = solve(s);
        hm.put(n, str);
        return str;
    }
    public String solve(String s){
        StringBuilder sb = new StringBuilder();
        char tar = '$';
        int freq = 0;
        for(char ch:s.toCharArray()) {
            if(ch != tar) {
                if(tar != '$') {
                    sb.append(freq);
                    sb.append(tar);
                }
                tar = ch;
                freq = 1;
            } else {
                freq++;
            }
        }
        sb.append(freq);
        sb.append(tar);
        return sb.toString();
    }
}