// { Driver Code Starts
//Initial template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{
    static int NumberOfTurns(Node root, int strt, int dest){
        
        List<Character> al1 = new ArrayList<>(), al2 = new ArrayList<>();
        
        getLca(root, strt, al1);
        getLca(root, dest, al2);
        
        int ans = 0;
        int n1 = al1.size()-1, n2 = al2.size()-1, i = 0;
        while(n1 >= 0 && n2 >= 0 && al1.get(n1) == al2.get(n2)) {
            i++; n1--; n2--;
        }
        
        // System.out.println(n1 +" "+ n2);
        
        if(!(n1<0 || n2<0)) ans++;
        for(int j=1; j <= n1; j++){
            if(al1.get(j) != al1.get(j-1)) ans++;
        }
        for(int j=1; j <= n2; j++){
            if(al2.get(j) != al2.get(j-1)) ans++;
        }
        return ans==0?-1:ans;
    }
    public static boolean getLca(Node root, int val, List<Character>al){
        if(root == null) return false;
        if(root.data == val) return true;
        if(getLca(root.left, val, al)) {al.add('L'); return true;}
        if(getLca(root.right, val, al)) {al.add('R'); return true;}
        return false;
    }
}