class Solution {
    public int threeSumMulti(int[] A, int target) {
        long[] count = new long[101];
        int uniq = 0;
        for (int x: A) {
            count[x]++;
            if (count[x] == 1)
                uniq++;
        }

        int[] keys = new int[uniq];
        int t = 0;
        for (int i = 0; i <= 100; ++i)
            if (count[i] > 0)
                keys[t++] = i;

        long ans = 0;

        for (int i = 0; i < keys.length; ++i) {
            int x = keys[i];
            int new_tar = target - x;
            int j = i, k = keys.length - 1;
            while (j <= k) {
                int y = keys[j], z = keys[k];
                if (y + z < new_tar) j++;
                else if (y + z > new_tar) k--;
                else {
                    if (i < j && j < k) ans += count[x] * count[y] * count[z];
                    else if (i == j && j < k) ans += count[x] * (count[x] - 1) / 2 * count[z];
                    else if (i < j && j == k) ans += count[x] * count[y] * (count[y] - 1) / 2;
                    else ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                    ans %= (1e9+7);
                    j++;
                    k--;
                }
            }
        }

        return (int) ans;
    }
}