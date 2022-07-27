// O(nlogn) sorting
/*
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
*/

// O(n) prefix array
class Solution {
    public int maximumSwap(int n) {
        List<Integer>al = new ArrayList<>();
        List<Integer>helper = new ArrayList<>();        
        
        do{
            al.add(0, n % 10);
            n /= 10;
        } while(n > 0);
        
        helper.add(al.size()-1);
        
        int max = al.get(al.size()-1), maxi = al.size()-1;
        for(int i=al.size()-2; i>=0; i--) {
            helper.add(0, maxi);
            if(al.get(i) > max) {
                max = al.get(i);
                maxi = i;
            }
        }
        
        for(int i=0; i<al.size(); i++) {
            if(al.get(i) < al.get(helper.get(i))) {
                int temp = al.get(i);
                al.set(i, al.get(helper.get(i)));
                al.set(helper.get(i), temp);
                break;
            }
        }
        
        int ans = 0;
        for(int i=0; i<al.size(); i++) {
            ans *= 10;
            ans += al.get(i);
        }
        return ans;
    }
}