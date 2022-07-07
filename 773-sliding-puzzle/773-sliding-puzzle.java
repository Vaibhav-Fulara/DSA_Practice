class Solution {
    public int slidingPuzzle(int[][]arr) {
        Queue<String>qu = new ArrayDeque<>();
        
        Set<String>vis = new HashSet<>();
        int[][]dirs = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
        
        String s = getBoardConfig(arr);
        qu.add(s);
        vis.add(s);
        
        int count = -1;
        while(qu.size()!=0){
            int len = qu.size();
            count ++;
            for(int q= 0; q<len; q++){
                String p = qu.poll();

                if(p.equals("123450")) return count;

                int zeroidx = p.indexOf('0');
                for(int i:dirs[zeroidx]){
                    String nconfig = swap(p, zeroidx, i);
                    if(!vis.contains(nconfig)){
                        String np = nconfig;
                        vis.add(nconfig);
                        qu.add(np);
                    }
                }
            }
        }
        
        return -1;
    }
    
    public String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        char ch1 = sb.charAt(i);
        char ch2 = sb.charAt(j);
        sb.setCharAt(i,ch2);
        sb.setCharAt(j,ch1);
        return sb.toString();
    }
    
    public String getBoardConfig(int[][]arr){
        StringBuilder sb = new StringBuilder();
        for(int x=0; x<arr.length; x++){
            for(int y=0; y<arr[0].length; y++){
                sb.append(arr[x][y]);
            }
        }
        return sb.toString();
    }
}
