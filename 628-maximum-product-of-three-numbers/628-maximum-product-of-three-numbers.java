class Solution {
    public int maximumProduct(int[]arr) {
        int min1 = 1001;
        int min2 = 1001;
        int max1 = -1001;
        int max2 = -1001;
        int max3 = -1001;
        
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num < min2) {
                min2 = num;
            }
            
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}