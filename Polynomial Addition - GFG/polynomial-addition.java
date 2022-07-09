// { Driver Code Starts
import java.util.Scanner;
import java.io.*;
class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}
class GFG2
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node start1=null,cur1=null,start2=null,cur2=null;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start1==null)
                {
                    start1=ptr;
                    cur1=ptr;
                }
                else{
                    cur1.next=ptr;
                    cur1=ptr;
                }
            }
            n=sc.nextInt();
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start2==null)
                {
                    start2=ptr;
                    cur2=ptr;
                }
                else{
                    cur2.next=ptr;
                    cur2=ptr;
                }
            }
            Solution obj=new Solution();
            Node sum = obj.addPolynomial(start1,start2);
            for(Node ptr=sum ; ptr != null; ptr=ptr.next  )
            {
                // printing polynomial
                System.out.print(ptr.coeff + "x^" + ptr.pow);
                if(ptr.next != null)
                System.out.print(" + ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

//Print the polynomial formed by adding both LL in the function itself.

// wont import
/*
import java.util.*;
class Solution{
    Node lo = null, high = null;
    public static Node addPolynomial(Node p1,Node p2){
        HashMap<Integer, Node>hs = new HashMap<>();
        Node ans = new Node(0, 0);
        Node temp = ans;
        while(p1!=null){
            Node node = new Node(p1.coeff, p1.pow);
            if(lo == null) {
                lo = node;
                hi = node;
            } else if(lo.pow > node.pow) {
                lo = node;
            } else if(hi.pow < node.pow) {
                hi = node;
            } else {
                temp.next = node;
                hm.add(p1.pow, node);
                temp = temp.next;
                p1 = p1.next;
            }
        }
        while(p2!=null){
            if(hm.containsKey(p2.pow)){
                Node node = hm.get(p2.pow);
                node.coeff += p2.coeff;
            } else {
                Node node = new Node(p2.coeff, p2.pow);
                if(p2.pow > hi.pow){
                    hi.next = node;
                    hi = hi.next;
                } else if(p2.pow < lo.pow) {
                    p2.next = lo;
                    lo = p2;
                } else {
                    Node left = -1, right = -1;
                    for(int l = p2.pow-1; l >=0; l--){
                        if(hm.containsKey(l)){
                            left = hm.get(l);
                            break;
                        }
                    }
                    for(int h = p2.pow+1; ; h++){
                        if(hm.containsKey(h)){
                            right = hm.get(h);
                            break;
                        }
                    }
                    left.next = node;
                    node.next = right;
                }
            }
            p2 = p2.next;
        }
        return ans.next;
    }
}
*/

class Solution{
    public static Node addPolynomial(Node p1,Node p2){
        Node ans = new Node (0,0);
        Node temp = ans;
        while(p1 != null && p2 != null){
            if(p1.pow == p2.pow){
                Node node = new Node(p1.coeff + p2.coeff, p1.pow);
                temp.next = node;
                temp = temp.next;
                p1 = p1.next;
                p2 = p2.next;
            } else if(p2.pow > p1.pow) {
                Node node = new Node(p2.coeff, p2.pow);
                temp.next = node;
                temp = temp.next;
                p2 = p2.next;
            } else {
                Node node = new Node(p1.coeff, p1.pow);
                temp.next = node;
                temp = temp.next;
                p1 = p1.next;
            }
        }
        
        while(p1 != null){
            temp.next = new Node(p1.coeff, p1.pow);
            p1 = p1.next;
            temp = temp.next;
        }
        
        while(p2 != null){
            temp.next = new Node(p2.coeff, p2.pow);
            p2 = p2.next;
            temp = temp.next;
        }
        
        return ans.next;
    }
}