class Solution {
     public class Number {
        int value;
        int index;
        int smaller;
        public Number(int value,int index,int smaller){
            this.value = value;
            this.index = index;
            this.smaller = smaller;
        }
    }
    public List<Integer> countSmaller(int[]arr) {
        
        Number[]nums = new Number[arr.length];
        for(int i=0; i<arr.length; i++) nums[i] = new Number(arr[i],i,0);
        mergeSort(arr, 0, arr.length-1, nums);
        
        Arrays.sort(nums,(n1,n2)->(n1.index-n2.index));
        
        List<Integer>al = new ArrayList<>();
        for(Number numb:nums) al.add(numb.smaller);
        return al;
    }
    
    public Number[] mergeSort(int[]arr, int lo, int hi, Number[]nums) {
        if(lo == hi) return new Number[]{nums[lo]};
        int mid = lo + (hi-lo)/2;
        Number[]left = mergeSort(arr, lo, mid, nums);
        Number[]right = mergeSort(arr, mid + 1, hi, nums);
        Number[]temp = mergeSorted(left, right);

        return temp;
    }
    
    public Number[] mergeSorted(Number[]arr1, Number[]arr2) {
        int length = arr1.length + arr2.length;
        Number[]arr = new Number[length];
        int i = 0, j = 0, k = 0;
        
        while(k<length){
            if(i<arr1.length && j< arr2.length){
                if(arr1[i].value <= arr2[j].value){
                    arr1[i].smaller += j;
                    arr[k++] = arr1[i++];
                }
                else arr[k++] = arr2[j++];
            }
            else if (i!=arr1.length) {
                arr1[i].smaller += j;
                arr[k++] = arr1[i++];
            }
            else arr[k++] = arr2[j++];
        }
        return arr;
    }
}