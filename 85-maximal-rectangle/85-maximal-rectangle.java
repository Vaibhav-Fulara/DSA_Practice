class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max_area = 0;
        int[][]arr= new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = matrix[i][j]-'0';
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(arr[i][j]!=0) arr[i][j]+=arr[i-1][j];
            }
        }
        
        for(int[]row:arr){
            max_area = Math.max(max_hist(row), max_area);
        }
        return max_area;
    }
    
    public static int max_hist(int[]arr){
        int[]right = NSOR(arr);
        int[]left = NSOL(arr);
        int max = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]*(right[i]-left[i]-1));
            
        }
        return max;
    }
    public static int[] NSOR (int[]arr){
        Stack<Integer>st = new Stack<>();
        int[]ans = new int[arr.length];
        Arrays.fill(ans, arr.length);
        st.push(0);
        for(int i=1; i<arr.length; i++){
            while(st.size()!=0 && arr[i]<arr[st.peek()]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] NSOL (int[]arr){
        Stack<Integer>st = new Stack<>();
        int[]ans = new int[arr.length];
        Arrays.fill(ans,-1);
        st.push(arr.length-1);
        for(int i=arr.length-2; i>=0; i--){
            while(st.size()!=0 && arr[st.peek()]>arr[i]){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}