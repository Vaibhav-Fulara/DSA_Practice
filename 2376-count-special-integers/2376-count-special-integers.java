class Solution {
  private static final List<Long> vals = new ArrayList<>();
  private static int len = 0;
  static {
    len = 10;
    for (int i = 1; i <= len; i++) dfs(0L, 0, i, 2000000000, 0);
  }
    
  public int countSpecialNumbers(int n) {
    int idx = Collections.binarySearch(vals, 0L + n);
    if (idx < 0) return -(idx + 1);
    return idx + 1;
  }
  
  // private void dfs(int val, int idx, int len, int mask) {
  private static void dfs(long val, int idx, int len, int max, int mask) {
    if (idx == len) {
      if (val <= max && val > 0) {
        vals.add(val);
      }
      return;
    }
    
    // choose an unused digit
    for (int i = 0; i <= 9; i++) if ((mask & (1 << i)) == 0) {
      if (val == 0 && i == 0) continue;
      dfs(val * 10 + i, idx + 1, len, max, mask ^ (1 << i));
    }
  }
    
  private static int computeLen(int n) {
    int res = 0;
    while (n > 0) {
      n /= 10;
      res++;
    }
    return res;
  }
}