class Solution {
    public int maximumUnits(int[][] arr, int cap) {
        Arrays.sort(arr, (a,b)->{
            return b[1]-a[1];
        });
        int units = 0;
        for(int i=0; i<arr.length; i++){
            if(cap > arr[i][0]){
                units += arr[i][0] * arr[i][1];
                cap -= arr[i][0];
            } else {
                units += cap * arr[i][1];
                break;
            }
        }
        return units;
    }
}