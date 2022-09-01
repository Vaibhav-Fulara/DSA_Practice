// O(n^2)
/*
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer>al = new ArrayList<>();
        inorder(root, al);
        int[]arr = new int[al.size()+1];
        int i=0;
        for(int a:al) arr[i++] = a;
        arr[i] = val;
        return constructMaximumBinaryTree(arr);
    }
    public void inorder(TreeNode root, List<Integer>al) {
        if(root == null) return;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
    public TreeNode solve(int[]nums, int strt, int end) {
        if(strt > end) return null;
        if(strt == end) return new TreeNode(nums[strt]);
        int max = strt;
        for(int i=strt; i<=end; i++) {
            if(nums[i] > nums[max]) max = i;
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = solve(nums, strt, max-1);
        root.right = solve(nums, max+1, end);
        return root;
    }
}
*/

// O(n)
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode (val);
        if(root.val < val) {
            TreeNode node = new TreeNode (val);
            node.left = root;
            return node;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}