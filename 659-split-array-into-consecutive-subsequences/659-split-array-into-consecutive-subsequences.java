class Solution {
    public boolean isPossible(int[]arr) {
        
        boolean[]b = new boolean[arr.length];
        Map<Integer, Integer>map = new HashMap<>();
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<arr.length; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        
        for(int i=0; i<arr.length; i++) {
            int m = arr[i];
            if(! map.containsKey(m)) {
                // System.out.println(m +" DONE");
                continue;
            } else if(hm.containsKey(m-1)){
                // if(hm.get(m-1) == null) System.out.println(m + " NULL");
                // else System.out.println(m +" "+ hm.get(m-1));
                
                if(map.get(m) > 1) map.put(m, map.get(m)-1);
                else map.remove(m);
                
                hm.put(m-1, hm.get(m-1)-1);
                if(hm.get(m-1) == 0) hm.remove(m-1);
                
                hm.put(m, hm.getOrDefault(m, 0) + 1);
            } else if (map.containsKey(m+1) && map.containsKey(m+2)){
                
                // System.out.println(m);
                if(map.get(m) > 1) map.put(m, map.get(m)-1);
                else map.remove(m);
                
                if(map.get(m+1) > 1) map.put(m+1, map.get(m+1)-1);
                else map.remove(m+1);
                
                if(map.get(m+2) > 1) map.put(m+2, map.get(m+2)-1);
                else map.remove(m+2);
                
                hm.put(m+2, hm.getOrDefault(m+2, 0) + 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}