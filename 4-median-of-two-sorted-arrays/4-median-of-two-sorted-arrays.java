class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        if(n1.length > n2.length) {
            int[]temp = n1;
            n1 = n2;
            n2 = temp;
        }
        
        int lo = 0;
        int hi = n1.length;
        
        while(lo <= hi) {
            int x = lo + (hi-lo)/2;
            int y = (n1.length+n2.length)/2 - x;
            
            int l1 = x == 0 ? Integer.MIN_VALUE:n1[x-1];
            int l2 = y == 0 ? Integer.MIN_VALUE:n2[y-1];
            int r1 = x == n1.length ? Integer.MAX_VALUE:n1[x];
            int r2 = y == n2.length ? Integer.MAX_VALUE:n2[y];
            
            if(l1 > r2) {
                hi = x - 1;
            } else if (l2 > r1) {
                lo = x + 1;
            } else {
                if((n1.length + n2.length) % 2 == 0) {
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2))/2;
                } else {
                    return (double)Math.min(r1, r2);
                }
            }
        }
        return -1d;
    }
}