class Solution {
    public boolean makesquare(int[] matchsticks) {
        int[]arr = new int[4];
        int sum = 0;
        Arrays.sort(matchsticks);
        for(int val:matchsticks) {
            sum += val;
        }
        if(sum % 4 != 0) return false;
        return formSticks(matchsticks, arr, matchsticks.length-1, sum/4);
    }
    public boolean formSticks(int[]matches, int[]arr, int i, int tar) {
        if(i == -1){
            if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) return true;
            return false;
        }
        for(int j=0; j<4; j++) {
            if(arr[j] + matches[i] > tar) continue;
            arr[j] += matches[i];
            if(formSticks(matches, arr, i-1, tar)) return true;
            arr[j] -= matches[i];
        }
        return false;
    }
}