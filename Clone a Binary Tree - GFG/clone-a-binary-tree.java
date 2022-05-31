// { Driver Code Starts
import java.util.*;
import java.lang.*;
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}
class CloneABT{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		int n,n1,n2;
		char lr;
		Tree root;
		while(q-->0){
			n=sc.nextInt();
			root=null;
			Solution g=new Solution();
			while(n-->0){
				n1=sc.nextInt();
				n2=sc.nextInt();
				lr=sc.next().charAt(0);
				if(root==null){
					root=new Tree(n1);
					switch(lr){
						case 'L':root.left=new Tree(n2);
						break;
						case 'R':root.right=new Tree(n2);
						break;
					}
				}
				else{
					if(lr=='X')
						clone(root,root,n1,n2);
					else
					insert(root,n1,n2,lr);
				}
			}
		try{Tree z=g.cloneTree(root);
	if(z==root)
        System.out.println("0");
     else
     {
         if(printInorder(root,z))
            System.out.println("1");
            
        else
            System.out.println("0");
            
     }
		}catch(ClassCastException ex){}
		}
	}
public static boolean printInorder(Tree a,Tree b){
    if((a==null) && (b==null))
        return true;
        
    if(a!=null && b!=null)
    {
       boolean check=((a.data==b.data) && printInorder(a.left,b.left) && printInorder(a.right,b.right));
        
        if(a.random!=null && b.random!=null)
            return (check && (a.random.data==b.random.data));
            
        if(a.random==b.random)
            return check;
            
        return false;
        
    }
    
   /* if(a.random.data == b.random.data) 
		if(printInorder(a.left,b.left)==1) 
			if(printInorder(a.right,b.right)==1)
				return 1;*/
    return false;

}
public static void clone(Tree root,Tree proot,int n1,int n2){
	try{if(root==null && proot==null)
		return;
	if(n1==root.data){
		if(proot.data==n2)
			root.random=proot;
		else{
			clone(root,proot.left,n1,n2);
			clone(root,proot.right,n1,n2);
		}
	}
	else{
		clone(root.left,proot,n1,n2);
		clone(root.right,proot,n1,n2);
	}}catch(NullPointerException ex){}
}
public static void insert(Tree root,int n1,int n2,char lr){
	if(root==null)
		return;
	if(n1==root.data){
		switch(lr){
						case 'L':root.left=new Tree(n2);
						break;
						case 'R':root.right=new Tree(n2);
						break;
					}
	}
	else{
		insert(root.left,n1,n2,lr);
		insert(root.right,n1,n2,lr);
	}
}
}// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class Solution{
    public Tree cloneTree(Tree tree){
       HashMap<Tree, Tree>hm = new HashMap<>();
       hm.put(null, null);
       Tree copy = new Tree(tree.data);
       return euler(tree, copy, hm);
    }
    public Tree euler(Tree tree, Tree copy, HashMap<Tree, Tree>hm){
        if(tree == null) return null;
        
        if(hm.containsKey(tree.left)) copy.left = hm.get(tree.left);
        else {
            Tree left = new Tree(tree.left.data);
            copy.left = left;
            hm.put(left, left);
        }
        
        if(hm.containsKey(tree.right)) copy.right = hm.get(tree.right);
        else {
            Tree right = new Tree(tree.right.data);
            copy.right = right;
            hm.put(right, right);
        }
        
        if(hm.containsKey(tree.random)) copy.random = hm.get(tree.random);
        else {
            Tree random = new Tree(tree.random.data);
            copy.random = random;
            hm.put(random, random);
        }
        
        copy.left = euler(tree.left, copy.left, hm);
        copy.right = euler(tree.right, copy.right, hm);
        return copy;
    }
}