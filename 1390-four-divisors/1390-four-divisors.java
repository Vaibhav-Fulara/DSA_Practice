class Solution {
    public int sumFourDivisors(int[]arr) {
        int ans = 0;
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(hm.containsKey(arr[i])) {
                if(hm.get(arr[i]) != -1) ans += hm.get(arr[i]);
                continue;
            }
            int r = getDivisors(arr[i]);
            if(r != -1) ans += r;
            hm.put(arr[i], r);
        }
        return ans;
    }
    public int getDivisors(int n) {
        int c = 2;
        int sum = 1 + n;
        for(int i=2; i*i <= n; i++) {
            if(n % i == 0) {
                sum += i;
                sum += n/i;
                c += 2;
                if(i == n/i) c--;
            }
            if(c > 4) break;
        }
        if(c == 4) return sum;
        return -1;
    }
}