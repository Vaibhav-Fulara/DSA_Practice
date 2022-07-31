// Brute O(1), O(1), O(n) solution
/*
class NumArray {
    int[]arr;
    public NumArray(int[] nums) {
        arr = nums;
    }
    
    public void update(int i, int val) {
        arr[i] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left; i<=right; i++) {
            sum += arr[i];
        } 
        return sum;
    }
}
*/

// O(n), O(logn), O(logn) recursive

public class NumArray {

    int n;
    int[] raw;
    NumArray parent;

    public NumArray(int[] nums) {
        n = nums.length;
        raw = nums;
        if (n>1) {
            int[] parRaw = new int[(n+1)/2];
            for (int i=0; i<n; i++) {
                parRaw[i/2]+=nums[i];
            }
            parent = new NumArray(parRaw);
        }
    }

    public void update(int i, int val) {
        if (n>1) parent.update(i/2, parent.get(i/2)-raw[i]+val);
        raw[i]=val;
    }

    public int get(int i) {
        return raw[i];
    }

    public int sumRange(int i, int j) {
        if (i>0) {
            return sumRange(0,j) - sumRange(0,i-1);
        } else if (j==0) {
            return raw[0];
        } else {
            int sum = parent.sumRange(0,j/2);
            if (j%2==0 && j+1<n) {
                sum -= raw[j+1];
            }
            return sum;
        }
    }
}