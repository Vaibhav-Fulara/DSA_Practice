class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][]arr = new char[n][n];
        for(char[]val:arr) Arrays.fill(val, '.');
        List<List<String>>al = new ArrayList<>();
        
        solveBoard(arr, n, 0, al);
        return al;
    }
    public void addToList(char[][]arr, List<List<String>>al){
        
        List<String>temp = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            String str = "";
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == '.') str += '.';
                else str += "Q";
            }
            temp.add(str);
        }
        
        al.add(new ArrayList<>(temp));
    }
    public void solveBoard(char[][]arr, int n, int i, List<List<String>>al){
        if(i == n) {
            addToList(arr, al);
            return;
        }
        for(int j=0; j<n; j++){
            if(isValid(arr, n, i, j)) {
                arr[i][j] = 'Q';
                solveBoard(arr, n, i+1, al);
                arr[i][j] = '.';
            }
        }
    }
    public boolean isValid(char[][]arr, int n, int row, int col){
        for(int i=0; i<row; i++) if(arr[i][col] == 'Q') return false;
        for(int i=row, j = col; i>=0 && j>=0; i--, j--) if(arr[i][j] == 'Q') return false;
        for(int i=row, j=col; i>=0 && j<n; i--, j++) if(arr[i][j] == 'Q') return false;
        return true;
    }
}