class Solution {
    public int maximumGroups(int[] grades) {
        int idx = 0;
        int curr = 1;
        int count = 0;
        int max = 0;
        while(idx + curr <= grades.length) {
            idx += curr++;
            count++;
        }
        return count;
    }
}
/*
[47,2,16,17,41,4,38,23,47]
3 AC
4 WA
2 4 16 17 23 38 41 47 47
*/