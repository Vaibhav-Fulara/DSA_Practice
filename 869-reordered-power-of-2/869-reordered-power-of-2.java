class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n == 1) return true;
        char[]arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        String s = Arrays.toString(arr);
        for(int i=0; i<31; i++) {
            int val = 1<<(i);
            char[]temp = String.valueOf(val).toCharArray();
            Arrays.sort(temp);
            // System.out.println(s + Arrays.toString(temp));
            if(Arrays.toString(temp).equals(s)) return true;
        }
        return false;
    }
}

// 1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384