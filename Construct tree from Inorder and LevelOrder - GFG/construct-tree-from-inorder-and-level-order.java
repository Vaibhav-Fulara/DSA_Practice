// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/

class GfG{
    Node buildTree(int in[], int level[])    {
        Map<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<in.length; i++) hm.put(level[i], i);
        return construct(in, hm, 0, in.length-1);
    }
    Node construct(int[]in, Map<Integer, Integer>hm, int ins, int ine){
        if(ine < ins) return null;
        if(ine == ins) return new Node(in[ine]);
        
        int strt = ins;
        for(int i= ins+1; i<=ine; i++) if(hm.get(in[strt]) > hm.get(in[i])) strt = i;
        
        Node node = new Node(in[strt]);
        node.left = construct(in, hm, ins, strt-1);
        node .right = construct(in, hm, strt+1, ine);
        return node;
    }
}


