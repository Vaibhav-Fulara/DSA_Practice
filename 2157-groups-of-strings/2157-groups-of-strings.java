class Solution {
    public int[] groupStrings(String[] words) {
        int[] groups = new int[words.length];
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i< words.length; i++){
            groups[i] = i;
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            list.add(str);
            if(!map.containsKey(str)){
                map.put(str, i);
            }
        }
        Collections.sort(list, (a,b) -> a.length() - b.length());
        Map<String, String> m = new HashMap<>();
        for(String str: list){
            for(int i = 0; i< str.length() ; i++){
                String s = str.substring(0,i) + str.substring(i+1, str.length());
                if(map.containsKey(s)){
                    int g1 = pc(groups, map.get(s));
                    int g2 = pc(groups, map.get(str));
                    if(g1 == g2) continue;
                    groups[g1] = g2;
                }
                if(m.containsKey(s)){
                    int g1 = pc(groups, map.get(m.get(s)));
                    int g2 = pc(groups, map.get(str));
                    if(g1 == g2) continue;
                    groups[g1] = g2;
                }
                m.put(s, str);
            }
        }
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int maxSize = 0;
        for(String str: list){
            int g = pc(groups, map.get(str));
            sizeMap.put(g, sizeMap.getOrDefault(g, 0) + 1);
            if(sizeMap.get(g) > maxSize) maxSize = sizeMap.get(g);
        }
        int[]res = new int[2];
        res[0] = sizeMap.size();
        res[1] = maxSize;
        return res;
    }
    private int pc(int[] groups, int num){
        if(groups[num] == num) return groups[num];
        groups[num] = pc(groups, groups[num]);
        return groups[num];
    }
}