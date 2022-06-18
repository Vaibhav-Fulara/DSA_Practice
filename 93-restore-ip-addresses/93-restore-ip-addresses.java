class Solution {
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String ip) {
        getSol(ip, new StringBuilder(), 3, 0, 0);
        return list;
    }
    public void getSol(String ip, StringBuilder sb, int val, int i, int curr){
        if(i > ip.length() || val < 0 || curr > 255) return;
        if(i == ip.length()) {
            if(val == 0 && sb.charAt(sb.length()-1) != '.') list.add(sb.toString());
            return;
        }
        if(ip.charAt(i) == '0'){
            // System.out.println(curr);
            if(curr*10 <= 255){
                
                sb.append("0.");
                getSol(ip, sb, val-1, i+1, 0);
                int n = sb.length()-1;
                sb.deleteCharAt(n-1);
                sb.deleteCharAt(n-1);

                if(i == ip.length()-1 || curr != 0){
                    sb.append("0");
                    getSol(ip, sb, val, i+1, curr*10);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        else{
            // System.out.println(curr);
            if(curr*10 + ip.charAt(i)-'0' <= 255){
                sb.append(ip.charAt(i));
                if(i != ip.length()-1){
                    sb.append(".");
                    getSol(ip, sb, val-1, i+1, 0);
                    sb.deleteCharAt(sb.length()-1);
                }
                getSol(ip, sb, val, i+1, curr*10 + ip.charAt(i)-'0');
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}