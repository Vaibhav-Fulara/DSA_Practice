class Solution {
    public char[][]keys = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String>al = new ArrayList<>();
        if(digits.length()==0) return al;
        getCombination(al, "", digits);
        return al;
    }
    public void getCombination(List<String>al, String ans, String str){
        if(str.length()==0){
            al.add(ans);
            return;
        }
        int idx = str.charAt(0)-'0';
        char[]vals = keys[idx];
        for(char val:vals) getCombination(al, ans+val, str.substring(1));
    }
}