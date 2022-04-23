class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int zero = 0, two = n-1, i = 0;
        
        while(i<=two){
            if(arr[i] == 0){
                int temp = arr[zero];
                arr[zero++] = 0;
                arr[i] = temp;
                i++;
            }
            else if(arr[i] == 2){
                int temp = arr[two];
                arr[two--] = 2;
                arr[i] = temp;
            }
            else i++;
        }
    }
}