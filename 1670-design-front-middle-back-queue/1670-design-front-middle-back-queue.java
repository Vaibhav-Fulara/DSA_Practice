class FrontMiddleBackQueue {
    List<Integer>al;
    public FrontMiddleBackQueue() {
        al = new ArrayList<>();
    }
    
    public void pushFront(int val) {
        al.add(0,val);
    }
    
    public void pushMiddle(int val) {
        if(al.size()%2 == 0) {
            al.add(al.size()/2,val);
        } else {
            al.add((al.size()-1)/2,val);
        }
    }
    
    public void pushBack(int val) {
        // System.out.println(al);
        al.add(val);
    }
    
    public int popFront() {
        if(al.size() == 0) return -1;
        // System.out.println(al);
        return al.remove(0);
    }
    
    public int popMiddle() {
        if(al.size() == 0) return -1;
        // System.out.println(al);
        if(al.size() == 1) return al.remove(0);
        return al.remove((al.size()-1)/2);
    }
    
    public int popBack() {
        if(al.size() == 0) return -1;
        return al.remove(al.size()-1);
    }
}

// 1, 4, 3, 2, 

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */