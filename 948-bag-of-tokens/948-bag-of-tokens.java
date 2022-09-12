class Solution {
    public int bagOfTokensScore(int[] arr, int power) {
        if(arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        if(arr[0] > power) return 0;
        int i=0, j=arr.length-1;
        int score = 0;
        while(i <= j) {
            if(power >= arr[i]) {
                score++;
                power -= arr[i];
            }
            else {
                if(i == j) break;
                power += arr[j] - arr[i];
                j--;
            }
            i++;
        }
        return score;
    }
}