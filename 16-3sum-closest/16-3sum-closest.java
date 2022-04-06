class Solution {
    public int threeSumClosest(int[]arr, int target) {
        Arrays.sort(arr);
        int temp = arr[0]+arr[1]+arr[2];
        for(int i=0; i<arr.length-2; i++){
            int x = arr[i];
            int left = i+1, right = arr.length-1;
            while(left<right){
                int y = arr[left], z = arr[right], sum = x+y+z;
                if(Math.abs(temp-target) > Math.abs(sum-target)) temp=sum;
                if(sum>target) right--;
                else if(sum<target) left++;
                else return sum;
            }
        }
        return temp;
    }
}