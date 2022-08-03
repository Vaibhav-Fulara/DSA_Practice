class Solution {
    public int[] smallestRange(List<List<Integer>>al) {
        int[]arr = new int[2];
        int min = Integer.MAX_VALUE;

        PriorityQueue<pair>pq = new PriorityQueue<>((a,b) -> {
            if(a == b) return a.idx - b.idx;
            return a.val - b.val;
        });

        int max = Integer.MIN_VALUE;
        int temp = Integer.MAX_VALUE;
        
        for(int i=0; i<al.size(); i++) {
            max = Math.max(max, al.get(i).get(0));
            pq.add(new pair(i, 0, al.get(i).get(0)));
        }
        
        arr[0] = pq.peek().val;
        arr[1] = max;
        min = arr[1] - arr[0];
        if(min == 0) return arr;
        
        while(true) {
            if(pq.size() == 0) break;
            pair p = pq.poll();
            // System.out.println(p.val+" "+p.list+" "+p.idx+" "+temp+" "+max + " " + pq.size());
            if(p.idx == al.get(p.list).size()-1) temp = Math.min(temp, p.val);
            if(p.idx != al.get(p.list).size()-1 || pq.size() == 0){
                // System.out.println(max-Math.min(p.val, temp));
                if(max-Math.min(p.val, temp) < min) {
                    min = max-Math.min(p.val, temp);
                    arr[0] = Math.min(p.val, temp);
                    arr[1] = max;
                }
                if(!(pq.size() == 0 && p.idx == al.get(p.list).size()-1)) {
                    int val = al.get(p.list).get(p.idx+1);
                    max = Math.max(max, val);
                    pq.add(new pair(p.list, p.idx+1, val));
                }
            }
        }
        
        return arr;
    }
    public class pair {
        int list;
        int idx;
        int val;
        public pair(int list, int idx, int val) {
            this.list = list;
            this.idx = idx;
            this.val = val;
        }
    }
}