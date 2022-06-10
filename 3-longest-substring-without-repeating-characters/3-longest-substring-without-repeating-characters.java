class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        Set<Character>hs = new HashSet<>();
        // hs.put(s.charAt(i));
        int i=0, j=0, count = 0, max = 0;
        while(j<s.length()){
            // char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!hs.contains(ch2)){
                count ++;
                hs.add(ch2);
                j++;
            }
            else{
                max = Math.max(count, max);
                // System.out.println(ch2);
                while(hs.contains(ch2)){
                    hs.remove(s.charAt(i));
                    count--; i++;
                }
                hs.add(ch2);
                j++; count++;
            }
        }
        return Math.max(max, count);
    }
}