class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>>ans = new ArrayList<>();
        Map<String, List<String>>hm = new HashMap<>();
        for(String p:paths) {
            String[]a = p.split("\\(");
            String[]c = p.split(" ");
            for(int i=1; i<a.length; i++) {
                String[]b = a[i].split("\\)");
                String concatenate = c[0] + '/' + c[i].split("\\(")[0];
                if(hm.containsKey(b[0])) {
                    hm.get(b[0]).add(concatenate);
                } else {
                    List<String>al = new ArrayList<>();
                    al.add(concatenate);
                    hm.put(b[0], al);
                }
            }
        }
        for(List<String>l:hm.values()) {
            if(l.size() > 1) ans.add(l);
        }
        return ans;
    }
}