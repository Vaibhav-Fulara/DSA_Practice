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

// O(n), O(logn), O(logn) Fenwick Tree

class NumArray {
    class FenwickTree {
        int[]arr;
        FenwickTree(int[]nums) {
            arr = new int[nums.length+1];
            for(int i=0; i<nums.length; i++) {
                this.update(i+1, nums[i]);
            }
        }
        
        int getSum(int pos) {
            int res = 0;
            
            while(pos > 0) {
                res += arr[pos];
                pos = pos-rsb(pos);
            }
            
            return res;
        }
        
        void update(int pos, int delta) {
            while(pos<arr.length) {
                arr[pos] += delta;
                pos = pos + rsb(pos);
            }
        }
        
        private int rsb(int x) {
            return x & (-x);
        }
    }
    
    FenwickTree ft;
    int[]oarr;
    public NumArray(int[] nums) {
        ft = new FenwickTree(nums);
        oarr = nums;
    }
    
    public void update(int i, int val) {
        int delta = val-oarr[i];
        ft.update(i+1, delta);
        oarr[i] = val;
    }
    
    public int sumRange(int left, int right) {
        int lpos = left + 1;
        int rpos = right + 1;
        
        int sumBeforeLeft = ft.getSum(lpos-1);
        int sumTillRight = ft.getSum(rpos);
        return sumTillRight-sumBeforeLeft;
    }
}