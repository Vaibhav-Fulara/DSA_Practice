class Solution {
    public long smallestNumber(long num) {
        int[] count = new int[10];
        long tempNum = num > 0 ? num : num * -1;
        int min = 10;
		
        while (tempNum > 0) {
            int rem = (int)(tempNum % 10);
            if (rem != 0) {
                min = Math.min(min, rem);
            }
            count[rem]++;
            tempNum = tempNum / 10;
        }
		
        long output = 0;
        if (num > 0) {
            output = output * 10 + min;
            count[min]--;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    output = output * 10 + i;
                }
            }
        } else {
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < count[i]; j++) {
                    output = output * 10 + i;
                }
            }
            output = output * -1;
        }
        return output;
    }
}