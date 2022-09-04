class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        if(root == null) return ans;
        
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->{
            if(a.hor == b.hor && a.vert == b.vert) return a.data.val - b.data.val;
            if(a.vert == b.vert) return a.hor - b.hor;
            return a.vert-b.vert;
        });
        
        int lo = 0, hi = 0;
        Queue<pair>qu = new ArrayDeque<>();
        qu.add(new pair(0,0,root));
        while(qu.size()!=0){
            pair p = qu.poll();
            TreeNode node = p.data;
            int v = p.vert;
            int h = p.hor;
            
            if(lo > v) lo = v;
            if(hi < v) hi = v;
            
            pq.add(p);
            
            if(node.left != null) qu.add(new pair(h+1, v-1, node.left));
            if(node.right != null) qu.add(new pair(h+1, v+1, node.right));
        }
        
        for(int i=lo; i<=hi; i++) ans.add(new ArrayList<>());
        int add = Math.abs(lo);
        
        while(pq.size()!=0){
            pair p = pq.remove();
            ans.get(p.vert+add).add(p.data.val);
        }
        return ans;
    }
    public class pair{
        int vert;
        int hor;
        TreeNode data;
        pair(int hor, int vert, TreeNode data){
            this.hor = hor;
            this.vert = vert;
            this.data = data;
        }
    }
}
