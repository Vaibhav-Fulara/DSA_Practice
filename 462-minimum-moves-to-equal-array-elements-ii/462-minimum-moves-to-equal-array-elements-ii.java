class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int av1 = nums[n/2];
        int av2 = av1;
        int idx = (int)Math.ceil((double)n/2);
        if(idx < nums.length) av2 = nums[idx];
        
        // System.out.println(av1 +" "+av2);
        
        int m1 = Math.abs(av1 - nums[0]), m2 = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            m1 += Math.abs(av1 - num);
        }
        if(av1 != av2){
            m2 = Math.abs(av2 - nums[0]);
            for(int i=1; i<nums.length; i++){
                int num = nums[i];
                m2 += Math.abs(av2 - num);
            }
        }
        // System.out.println(m1 +" "+m2);
        return Math.min(m1, m2);
    }
}