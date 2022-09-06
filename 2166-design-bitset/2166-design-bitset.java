class Bitset {
    int size;
    Set<Integer>ones;
    Set<Integer>zeroes;
    public Bitset(int size) {
        this.size = size;
        ones = new HashSet<>();
        zeroes = new HashSet<>();
        for(int i=0; i<size; i++) {
            zeroes.add(i);
        }
    }
    
    public void fix(int idx) {
        zeroes.remove(idx);
        ones.add(idx);
    }
    
    public void unfix(int idx) {
        ones.remove(idx);
        zeroes.add(idx);
    }
    
    public void flip() {
        Set<Integer>hs = ones;
        ones = zeroes;
        zeroes = hs;
    }
    
    public boolean all() {
        return size == ones.size();
    }
    
    public boolean one() {
        return ones.size() > 0;
    }
    
    public int count() {
        return ones.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            if(ones.contains(i)) sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx); * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */