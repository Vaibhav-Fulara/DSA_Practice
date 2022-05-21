class Solution {
    int[][]dirs = {{-1, -1}, {-1,1}, {1,-1}, {1,1}, {0,1}, {1,0}, {0,-1}, {-1,0}};
    public char[][] updateBoard(char[][] arr, int[] click) {
        int i = click[0], j = click[1];
        if(arr[i][j] == 'M') {
            arr[i][j] = 'X';
            return arr;
        }
        int count = 0;
        for(int[]dir:dirs){
            int x = i + dir[0], y = j + dir[1];
            if(x>=0 && x<arr.length && y>=0 && y<arr[0].length) if(arr[x][y] == 'M') count++;
        }
        if(count != 0){
            arr[i][j] = (char) ('0' + count);
            return arr;
        }
        else{
            arr[i][j] = 'B';
            for(int[]dir:dirs){
                int x = i + dir[0], y = j + dir[1];
                if(x>=0 && x<arr.length && y>=0 && y<arr[0].length && (arr[x][y] == 'E' || arr[x][y] == 'M')) updateBoard(arr, new int[]{x,y});
            }
        }
        return arr;
    }
}