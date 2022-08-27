class NumArray {
    
    public class Node {
        int strt, end, val;
        Node left, right;
    }
    
    public Node constructSegmentTree(int[]arr, int lo, int hi) {
        if(lo == hi) {
            Node node = new Node();
            node.strt = node.end = lo;
            node.val = arr[lo];
            return node;
        }
        
        Node node = new Node();
        int mid = (lo + hi)/2;
        
        Node left = constructSegmentTree(arr, lo, mid);
        Node right = constructSegmentTree(arr, mid+1, hi);
        
        node.left = left;
        node.right = right;
        node.val = left.val + right.val;
        node.strt = lo;
        node.end = hi;
        
        return node;
    }
    
    Node root;
    int[]arr;
    
    public NumArray(int[] nums) {
        root = constructSegmentTree(nums, 0, nums.length-1);
        arr = nums;
    }

    public void update(int index, int val) {
//         Node temp = root;
//         int diff = arr[index] - val;
//         arr[index] = val;
        
//         while(temp != null) {
//             temp.val -= diff;
//             if((temp.strt + temp.end) / 2 <= index) temp = temp.left;
//             else temp = temp.right;
//         }
        updateTree(root, index, val);
    }
    
    public void updateTree(Node node, int idx, int val) {
        if(node.strt == node.end) {
            node.val = val;
            return;
        }
        
        int mid = (node.strt + node.end)/2;
        if(idx <= mid) updateTree(node.left, idx, val);
        else updateTree(node.right, idx, val);
        node.val = node.left.val + node.right.val;
    }
    
    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }
    
    public int getSum(Node root, int left, int right) {
        if(root.strt > right || root.end < left) return 0;
        if(root.strt >= left && root.end <= right) return root.val;
        return getSum(root.left, left, right) + getSum(root.right, left, right);
    }
}