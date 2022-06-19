class Solution {
    public int nextGreaterElement(int n) {
        String s = Integer.toString(n);
        if(s.length() < 2) return -1;            // No reversed greater number for single digit numbers
        int[]arr = new int[s.length()];
        int i = 0;
        for(char ch:s.toCharArray()) arr[i++] = ch-'0';
        
        i = arr.length-2;
        while(i >= 0 && arr[i] >= arr[i+1]) i--;
        if(i < 0) return -1;
        
        int j = i+1;
        while(j+1 < arr.length && arr[j+1] > arr[i]) j++;
        // System.out.println(i +" " + prev);
        
        swap(arr, i, j);
        reverse(arr, i+1);
        
        int k = 0;
        long ans = 0;
        while(k < arr.length) ans = ans*10 + arr[k++];
        
        return ans == n || ans > Integer.MAX_VALUE ? -1:(int)ans;
    }
    
    public void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void reverse(int[]arr, int i){
        int n = arr.length-1;
        
        while(i < n){
            swap(arr, i, n);
            i++; n--;
        }
    }
}