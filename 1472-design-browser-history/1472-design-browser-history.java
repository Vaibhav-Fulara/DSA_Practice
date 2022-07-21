class BrowserHistory {
    Stack<String>back;
    String curr;
    Stack<String>forw;
    public BrowserHistory(String homepage) {
        back = new Stack<>();
        curr = homepage;
        forw = new Stack<>();
    }
    
    public void visit(String url) {
        back.push(curr);
        curr = url;
        forw = new Stack<>();
    }
    
    public String back(int steps) {
        if(back.size() == 0) return curr;
        forw.push(curr);
        steps = Math.min(steps, back.size())-1;
        while(steps > 0) {
            forw.push(back.pop());
            steps--;
        }
        return curr = back.pop();
    }
    
    public String forward(int steps) {
        if(forw.size() == 0) return curr;
        back.push(curr);
        steps = Math.min(steps, forw.size())-1;
        while(steps > 0) {
            back.push(forw.pop());
            steps--;
        }
        return curr = forw.pop();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */