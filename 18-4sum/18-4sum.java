class Solution {
    public List<List<Integer>> fourSum(int[] arr, int tar) {
        List<List<Integer>>al = new ArrayList<>();
        if(arr.length <= 3) return al;
        Arrays.sort(arr);
        
        for(int i=0; i < arr.length; i++){
            if(i != 0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j<arr.length; j++){
                if(j != i+1 && arr[j] == arr[j-1]) continue;
                int temp = tar - arr[i] - arr[j];
                int m = j+1;
                int n = arr.length - 1;
                while(m<n){
                    int sum = arr[m] + arr[n];
                    if(sum == temp){
                        List<Integer>list = Arrays.asList(new Integer[] {arr[i], arr[j], arr[m], arr[n]});
                        al.add(new ArrayList<>(list));
                        int curr = arr[m];
                        while(m < arr.length && curr == arr[m]) m++;
                        curr = arr[n];
                        while(n >= 0 && curr == arr[n]) n--;
                    }
                    else if(sum < temp) {
                        int curr = arr[m];
                        while(m < arr.length && curr == arr[m]) m++;
                    }
                    else {
                        int curr = arr[n];
                        while(n >= 0 && curr == arr[n]) n--;
                    }
                }
            }
        }
        return al;
    }
}