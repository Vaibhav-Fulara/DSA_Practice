class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>al = new ArrayList<>();
        if(n==0) return al;
        List<Integer>temp = new ArrayList<>();
        temp.add(1);
        al.add(temp);
        int i=1;
        while(n!=i){
            List<Integer>curr = new ArrayList<>();
            List<Integer>prev = al.get(i-1);
            curr.add(1);
            for(int j=0; j<prev.size()-1; j++) curr.add(prev.get(j)+prev.get(j+1));
            curr.add(1);
            al.add(curr);
            i++;
        }
        return al;
    }
}