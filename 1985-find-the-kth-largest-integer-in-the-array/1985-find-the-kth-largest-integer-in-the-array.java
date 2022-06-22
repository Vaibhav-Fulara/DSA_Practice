class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String>pq = new PriorityQueue<>((a,b) -> {
            if(a.length() == b.length()){
                for(int i=0; i<a.length(); i++){
                    char ch1 = a.charAt(i);
                    char ch2 = b.charAt(i);
                    if(ch1-'0' > ch2-'0') return -1;
                    if(ch1-'0' < ch2-'0') return 1;
                }
                return 0;
            }
            else return b.length()-a.length();
        });
        for(String val:nums) pq.add(val);
        while(k-- > 1) pq.poll();
        return pq.peek();
    }
}