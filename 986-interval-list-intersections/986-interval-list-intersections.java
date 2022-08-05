class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        
        if(first.length == 0 || second.length == 0) return new int[0][0];
        
        int i=0, j=0;
        List<int[]>al = new ArrayList<>();
        
        while(true) {
            
            while(i < first.length && j<second.length && first[i][1] < second[j][0]) i++;
            if(i == first.length) break;

            while(j < second.length && second[j][1] < first[i][0]) j++;
            if(j == second.length) break;
            
            int strt = Math.max(second[j][0], first[i][0]);
            int end = Math.min(second[j][1], first[i][1]);
            if(strt <= end) al.add(new int[]{strt, end});
            
            if(first[i][1] > second[j][1]) j++;
            else if(first[i][1] < second[j][1]) i++;
            else {i++; j++;}
        }
        
        int[][]arr = new int[al.size()][];
        for(int k=0; k<al.size(); k++) arr[k] = al.get(k);
        return arr;
    }
}