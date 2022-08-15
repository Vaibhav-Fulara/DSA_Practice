class Solution {
	public int maximumGap(int[] nums) {
	   int n = nums.length;
	   if(n < 2) return 0;

		int min = Integer.MAX_VALUE;
		int max = -1;

		for(int num : nums){
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
        
		int interval = (int)(Math.ceil((max - min + 0.0) / (n - 1)));
		if(interval == 0) return 0;

		int[] bucketMin = new int[n];
		int[] bucketMax = new int[n];

		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);

		for(int num : nums){
			int index = (num - min) / interval;

			bucketMin[index] = Math.min(bucketMin[index], num);
			bucketMax[index] = Math.max(bucketMax[index], num);
		}

		int prev = min;
		int maxGap = 0;

		for(int i = 0; i < n; i++){
			if(bucketMin[i] == Integer.MAX_VALUE)//no element in this bucket
				continue;

			int gap = bucketMin[i] - prev;
			maxGap = Math.max(maxGap, gap);

			prev = bucketMax[i];
		}

		return maxGap;
	}
}