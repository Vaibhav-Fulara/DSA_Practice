class Solution {
    public int minCost(int[] start, int[] home, int[] rowCosts, int[] colCosts) {
        int n = rowCosts.length;
        int m = colCosts.length;
        return getMin(start[0], start[1], home[0], home[1], rowCosts, colCosts, 0);
    }
    public int getMin(int sr, int sc, int dr, int dc, int[]row, int[]col, int cost){
        while(sr<dr){ sr++; cost += row[sr];}
        while(sc<dc){ sc++; cost += col[sc];}
        while(sr>dr){ sr--; cost += row[sr];}
        while(sc>dc){ sc--; cost += col[sc];}
        return cost;
    }
}