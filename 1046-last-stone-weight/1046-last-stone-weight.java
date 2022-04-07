class Solution {
    public int lastStoneWeight(int[] arr) {
        int m = arr.length-1;
        int n = arr.length-2;
        while(m>0){
            Arrays.sort(arr);
            if(arr[m]==arr[n]){
                m-=2;
                n-=2;
            }
            else{
                arr[n]=Math.abs(arr[n]-arr[m]);
                n--;
                m--;
            }
        }
        if(m<0) return 0;
        return arr[m];
    }
}