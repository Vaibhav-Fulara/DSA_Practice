class Solution {
    public int removeDuplicates(int[] arr) {
        int j=1;
        int rep = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1]){
                if(rep==2) continue;
                else {arr[j++] = arr[i]; rep++;}
            }
            else {rep = 1; arr[j++] = arr[i];}
        }
        return j;
    }
}