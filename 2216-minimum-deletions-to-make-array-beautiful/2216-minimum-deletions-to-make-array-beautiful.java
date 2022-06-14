class Solution {
    public int minDeletion(int[]arr) {
        boolean flag = true;
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
            if(flag && i % 2 == 0 && arr[i] == arr[i+1]){
                count ++;
                flag = false;
            }
            if(flag == false && i % 2 != 0 && arr[i] == arr[i+1]){
                count ++;
                flag = true;
            }
        }
        return (arr.length-count) % 2 == 0? count:count+1;
    }
}