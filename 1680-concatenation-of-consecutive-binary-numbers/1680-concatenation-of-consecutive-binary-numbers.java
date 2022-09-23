// TLE
/*
class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        int big = 1000000007;
        for(int i=1; i<=n; i++){
            String val = Integer.toBinaryString(i);
            sb.append(val);
            long num = Long.parseLong(sb.toString(),2);
            num %= big;
            sb = new StringBuilder(Integer.toBinaryString((int)num));
        }
        return Integer.parseInt(sb.toString(),2);
    }
}
*/

class Solution {
    public int concatenatedBinary(int n){
        int big=(int)(1e9+7);
        long e=0;
        int shift=0;
        for(int i=1;i<=n;i++){
            if((i-1 & i)==0)shift++;         
            e= ((e<<shift)+i) % big;
        }        
        return (int)e;           
    }
}