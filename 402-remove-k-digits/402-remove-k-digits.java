// TC = O(k*n)
/*
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        int i=0;
        while(i != sb.length()-1){
            if(sb.charAt(i) > sb.charAt(i+1)){
                char ch = sb.charAt(i);
                while(k > 0 && i >= 0 && sb.charAt(i) > sb.charAt(i+1)){
                    sb.deleteCharAt(i--);
                    k--;
                }
                if(k == 0) break;
            }
            i++;
        }
        String s = sb.substring(0, sb.length()-k);
        int idx=0;
        while(idx < s.length() && s.charAt(idx) == '0'){
            idx++;
            continue;
        }
        s = s.substring(idx);
        return s.equals("")? "0":s;
    }
}
*/

// Stack
// TC = 
public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k==len) return "0";
            
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();
    }
}