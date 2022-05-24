class Solution {
    public boolean isValidSudoku(char[][]arr) {
        Map<Integer, boolean[]>row = new HashMap<>();
        Map<Integer, boolean[]>col = new HashMap<>();
        Map<Integer, boolean[]>squares = new HashMap<>();
        
        for(int i=0; i<9; i++){
            row.put(i,new boolean[10]);
            col.put(i,new boolean[10]);
            squares.put(i,new boolean[10]);
        }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char ch = arr[i][j];
                if(ch != '.'){
                    if (row.get(i)[ch-'0'] == true) return false;
                    row.get(i)[ch-'0'] = true;
                    if (col.get(j)[ch-'0'] == true) return false;
                    col.get(j)[ch-'0'] = true;
                    if (squares.get(3*(i/3) + j/3)[ch-'0'] == true) return false;
                    squares.get(3*(i/3) + j/3)[ch-'0'] = true;
                }
            }
        }
        
        return true;
    }
}