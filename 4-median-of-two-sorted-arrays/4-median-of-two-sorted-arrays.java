/*
    We divide the two arrays int0 two new arrays such that the number of elements
    in both new subarrays are (len[1]+len[2])/2.
    
    In case the length is odd, we let the second array contain the extra element.
    
    l1 is the last number from first parent array in the first child array.
    l2 is the last number from second parent array in the first child array.
    r1 is the first number from first parent array in the second child array.
    r2 is the first number from second parent array in the second child array.
*/
/*
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
            int y = (n1.length+n2.length)/2 - x;        // letting the second arr contain the extra element
            
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
                    // In case of even number of elements, we avg the two partition extremities.
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2))/2;
                } else {
                    // In case of odd number of elements, the right subarray has greater number of elements.
                    return (double)Math.min(r1, r2);
                }
            }
        }
        return -1d;
    }
}
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int m1 = (m+n+1)/2;
        int m2 = (m+n+2)/2;
        
        int median1 = getKthElementFromMergedArray(nums1, nums2, m1, 0, 0);
        int median2 = getKthElementFromMergedArray(nums1, nums2, m2, 0, 0);
        
        return ((double)median1 + median2)/2;
    }
    
    public int getKthElementFromMergedArray(int[]nums1, int[]nums2, int k, int s1, int s2) {
        if(s1 >= nums1.length) return nums2[s2+k-1];
        if(s2 >= nums2.length) return nums1[s1+k-1];
        if(k == 1) return Math.min(nums1[s1], nums2[s2]);
        
        int ele1 = Integer.MAX_VALUE;
        int ele2 = Integer.MAX_VALUE;
        
        if(s1 + k/2-1 < nums1.length) ele1 = nums1[s1 + k/2 -1];
        if(s2 + k/2-1 < nums2.length) ele2 = nums2[s2 + k/2 -1];
        
        if(ele1 < ele2) {
            return getKthElementFromMergedArray(nums1, nums2, k-k/2, s1+k/2, s2);
        } else {
            return getKthElementFromMergedArray(nums1, nums2, k-k/2, s1, s2+k/2);
        }
    }
}