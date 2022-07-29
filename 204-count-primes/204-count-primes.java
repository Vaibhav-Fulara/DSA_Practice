class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        boolean[]arr = new boolean[n];
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i*i < n; i++){
            if(!arr[i]) {
                long temp = i*i;
                while(temp < n) {
                    // System.out.println(temp);
                    arr[(int)temp] = true;
                    temp += i;
                }
            }
        }
        int ans = 0;
        for(boolean bool:arr) if(!bool) ans ++;
        return ans;
    }
}