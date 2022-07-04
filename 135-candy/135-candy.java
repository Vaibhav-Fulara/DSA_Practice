class Solution {
    public int candy(int[] rating) {
        if(rating.length == 1) return 1;
        int[]candy = new int[rating.length];
        Arrays.fill(candy, 1);
        for(int i=1; i<candy.length; i++){
            if(rating[i] > rating[i-1]) candy[i] = candy[i-1] + 1;
        }
        for(int i=candy.length-1; i > 0; i--){
            if(rating[i-1] > rating[i] && candy[i-1] < candy[i]+1) {
                candy[i-1] = candy[i]+1;
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