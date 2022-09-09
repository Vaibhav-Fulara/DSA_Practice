class Solution {
    public int numberOfWeakCharacters(int[][]arr) {
        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0]) return a[1]-b[1];      // sorting lowest to highest for similar attack
                                                    // to ignore similar attack lower defence values
            return b[0]-a[0];                       // sorting highest to lowest
        });
        
        int ans = 0;
        int maxDef = arr[0][1];
        for(int i=1; i<arr.length; i++) {
            if(arr[i][1] < maxDef) ans++;
            maxDef = Math.max(maxDef, arr[i][1]);
        }
        return ans;
    }
}