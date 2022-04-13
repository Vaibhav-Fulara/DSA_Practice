class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int hspan = 1, lspan = 1, idx=1;
        int instances = rows*cols;
        int[][]arr = new int[instances][2];
        arr[0][0] = rStart;
        arr[0][1] = cStart;
        while(idx!=instances){
            for(int i=1; i<=lspan; i++){
                int col = cStart + i;
                if(rStart>=0 && rStart<rows && col>=0 && col<cols) {arr[idx][0] = rStart; arr[idx++][1] = col;}
            }
            cStart += lspan++;
            
            for(int i=1; i<=hspan; i++){
                int row = rStart + i;
                if(cStart>=0 && cStart<cols && row>=0 && row<rows) {arr[idx][0] = row; arr[idx++][1] = cStart;}
            }
            rStart += hspan++;
            
            for(int i=1; i<=lspan; i++){
                int col = cStart - i;
                if(rStart>=0 && rStart<rows && col>=0 && col<cols) {arr[idx][0] = rStart; arr[idx++][1] = col;}
            }
            cStart -= lspan++;
            
            for(int i=1; i<=hspan; i++){
                int row = rStart - i;
                if(cStart>=0 && cStart<cols && row>=0 && row<rows) {arr[idx][0] = row; arr[idx++][1] = cStart;}
            }
            rStart -= hspan++;
        }
        return arr;
    }
}