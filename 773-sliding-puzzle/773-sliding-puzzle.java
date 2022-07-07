class Solution {
    public int slidingPuzzle(int[][]arr) {
        Queue<pair>qu = new ArrayDeque<>();
        
        Set<String>vis = new HashSet<>();
        int[][]dirs = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
        
        String s = getBoardConfig(arr);
        qu.add(new pair(s,0));
        vis.add(s);
        
        while(qu.size()!=0){
            pair p = qu.poll();
            
            if(p.config.equals("123450")) return p.level;
            
            int zeroidx = p.config.indexOf('0');
            for(int i:dirs[zeroidx]){
                String nconfig = swap(p.config, zeroidx, i);
                if(!vis.contains(nconfig)){
                    pair np = new pair();
                    np.config = nconfig;
                    np.level = p.level + 1;
                    vis.add(nconfig);
                    qu.add(np);
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
    
    public class pair{
        String config;
        int level;
        pair(){}
        pair(String s, int y){
            config = s;
            level = y;
        }
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
