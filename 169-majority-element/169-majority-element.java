class Solution {
    public int majorityElement(int[] arr) {
        int ele = arr[0];
        int freq = 1;
        for(int i=1; i<arr.length; i++){
            if(freq <=0) {ele = arr[i]; freq=1;}
            else if(arr[i] == ele) freq++;
            else freq--;
        }
        return ele;
    }
}