class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        int e1 = 0, e2 = 0, c1 = 0, c2 =0;
        for(int val:nums){
            if(val == e1) c1 ++;
            else if(val == e2) c2 ++;
            else if(c1 == 0) {e1 = val; c1 = 1;}
            else if(c2 == 0) {e2 = val; c2 = 1;}
            else {c2--; c1--;}
        }
        if(check(e1, nums)) ans.add(e1);
        if(e1!=e2 && check(e2, nums)) ans.add(e2);
        return ans;
    }
    public boolean check(int n, int[]arr){
        int count = 0;
        for(int val:arr) if (val == n) count++;
        if(count > arr.length/3) return true;
        return false;
    }
}