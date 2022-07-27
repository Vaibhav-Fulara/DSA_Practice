class Solution {
    public int maximumSwap(int n) {
        List<Integer>al = new ArrayList<>();
        List<Integer>sorted = new ArrayList<>();        
        
        int temp = n;
        
        do{
            al.add(0, n % 10);
            sorted.add(n % 10);
            n /= 10;
        } while(n > 0);
        
        int broke = -1;
        
        Collections.sort(sorted, (a,b)->(b-a));
        for(int i=0; i<al.size(); i++) {
            if(al.get(i) != sorted.get(i)) {
                broke = i;
                break;
            }
        }
        
        if(broke == -1) return temp;
        int j = broke+1;
        int correct = j;
        while (correct < al.size()) {
            if(sorted.get(broke) == al.get(correct)) j = correct;
            correct++;
        }
        
        
        int a1 = al.get(j);
        al.set(j, al.get(broke));
        al.set(broke, a1);
        
        int ans = 0;
        for(int i=0; i<al.size(); i++) {
            ans *= 10;
            ans += al.get(i);
        }
        return ans;
    }
}