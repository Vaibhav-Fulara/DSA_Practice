class Solution {
    public long[] sumOfThree(long num) {
        if(num % 3 != 0) return new long[0];
        long[]arr = new long[3];
        
        long temp = num/3;
        arr[0] = temp-1;
        arr[1] = temp;
        arr[2] = temp+1;
        
        return arr;
    }
}