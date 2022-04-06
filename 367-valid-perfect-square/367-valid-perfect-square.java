class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        long lo = 2;
        long hi = num/2;
        long mid=0;
        while(lo <= hi){
            mid = (lo+hi)/2;
            if(mid*mid < num) lo = mid+1;
            else if(mid*mid > num) hi = mid-1;
            else return true;
        }
        System.out.println(mid*mid);
        return false;
    }
}