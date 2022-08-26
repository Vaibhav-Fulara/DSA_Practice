class Solution {
    public String largestNumber(int[] arr) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((n1,n2) -> {
            String a = String.valueOf(n1);
            String b = String.valueOf(n2);
            return (b+a).compareTo(a+b);
        });
        for(int val:arr) pq.add(val);
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) ans.append(pq.remove());
        while(ans.charAt(0) == '0' && ans.length() > 1) ans.deleteCharAt(0);
        return ans.toString();
    }
}