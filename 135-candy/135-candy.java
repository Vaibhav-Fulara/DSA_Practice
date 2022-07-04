class Solution {
    public int candy(int[] rating) {
        if(rating.length == 1) return 1;
        int[]candy = new int[rating.length];
        candy[0] = 1;
        for(int i=1; i<candy.length; i++){
            if(rating[i] > rating[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else if(rating[i] == rating[i-1]) {
                candy[i] = 1;
            } else {
                if(candy[i-1] != 1){
                    candy[i] = 1;
                } else {
                    int j = i;
                    candy[j] = 1;
                    while(j > 0 && rating[j-1] > rating[j] && candy[j-1] <= candy[j]){
                        candy[j-1] ++;
                        j--;
                    }
                }
            }
        }
        int candies = 0;
        for(int toffee:candy) {
            // System.out.print(toffee + " ");
            candies += toffee;
        }
        return candies;
    }
}