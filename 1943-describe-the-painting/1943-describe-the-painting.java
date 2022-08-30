class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int strt = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        Set<Integer>hs = new HashSet<>();
        
        for(int[]segment:segments) {
            strt = Math.min(strt, segment[0]);
            end = Math.max(end, segment[1]);
            hs.add(segment[1]);
        }
        
        long[]arr = new long[end+1];
        
        for(int[]segment:segments) {
            arr[segment[0]] += segment[2];
            if(segment[1] < arr.length) arr[segment[1]] -= segment[2];
        }
        
        List<List<Long>>al = new ArrayList<>();
        
        long s = -1;
        long og = 0;
        boolean bool = true;
        for(int i=strt; i<=end; i++) {
            if(arr[i] != 0 || hs.contains(i)) {
                if(!bool && og!=0) {
                    List<Long>a = new ArrayList<>();
                    a.add(s);
                    a.add((long)i);
                    a.add(og);
                    al.add(new ArrayList<>(a));
                }
                s = i;
                og += arr[i];
                bool = false;
            }
        }
        
        if(s != arr.length - 1 && og != 0) {
            List<Long>a = new ArrayList<>();
            a.add(s);
            a.add((long)arr.length-1);
            a.add(og);
            al.add(new ArrayList<>(a));
        }
         
        return al;
    }
}