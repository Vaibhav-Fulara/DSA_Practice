class Solution {
    public int[] sumEvenAfterQueries(int[]arr, int[][] queries) {
        int sum = 0;
        int[]ans = new int[queries.length];
        for(int val:arr) if(val % 2 == 0) sum += val;
        int i=0;
        for(int[]q:queries) {
            if(arr[q[1]] % 2 == 0) {
                int temp = arr[q[1]];
                arr[q[1]] += q[0];
                if(arr[q[1]] % 2 == 0) {
                    sum += q[0];
                } else {
                    sum -= temp;
                }
            } else {
                arr[q[1]] += q[0];
                if(arr[q[1]] % 2 == 0) sum += arr[q[1]];
            }
            ans[i++] = sum;
        }
        return ans;
    }
}