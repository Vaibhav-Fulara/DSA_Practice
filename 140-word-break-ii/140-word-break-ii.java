class Solution {
    List<String>ls;
    public List<String> wordBreak(String s, List<String> dict){
        ls = new ArrayList<>();
        solve(dict, s, 0, 0, "");
        return ls;
    }
    public void solve (List<String>dict, String s, int i, int j, String asf){
        if(j == s.length()){
            if(dict.contains(s.substring(i, j))){
                if(asf.equals("")) asf += s.substring(i,j);
                else asf += " " + s.substring(i,j);
                ls.add(asf);
            }
            return;
        }
        if(dict.contains(s.substring(i, j))){
            String st = asf;
            if(asf.equals("")) asf += s.substring(i,j);
            else asf += " " + s.substring(i,j);
            solve(dict, s, j,  j, asf);
            asf = st;
        }
        solve(dict, s, i, j+1, asf);
    }
}