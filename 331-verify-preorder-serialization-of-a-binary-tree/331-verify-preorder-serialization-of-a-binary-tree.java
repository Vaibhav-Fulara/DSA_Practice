class Solution{
    public boolean isValidSerialization(String preorder) {
        int nonleaves = 0, leaves = 0, i=0;
        String[] nodes = preorder.split(",");
        for (i=0; i<nodes.length && nonleaves + 1 != leaves; i++){
            if (nodes[i].equals("#")) leaves++;
            else nonleaves++;
        }
        return nonleaves + 1 == leaves && i == nodes.length;
    }
}