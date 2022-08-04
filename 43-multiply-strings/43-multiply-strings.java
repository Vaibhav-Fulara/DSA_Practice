class Solution {
    public String multiply(String s1, String s2) {
        if(s1.length() == 1 && s1.charAt(0) == '0' || s2.length() == 1 && s2.charAt(0) == '0') return "0";
        if(s1.length() > s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
        }
        List<List<Integer>>al = new ArrayList<>();
        int curr = 0;
        for(int i=s1.length()-1; i>=0; i--) {
            int mul = s1.charAt(i)-'0';
            // System.out.println("mul " + mul);
            if(mul == 0) {curr++; continue;}
            
            List<Integer>a = new ArrayList<>();
            for(int x=0; x<curr; x++) a.add(0);
            
            curr++;
            int rem = 0;
            
            for(int j=s2.length()-1; j>=0; j--) {
                int temp = rem + mul * (s2.charAt(j)-'0');
                // System.out.println(temp);
                a.add(0, temp % 10);
                rem = temp/10;
            }
            if(rem != 0) a.add(0, rem);
            al.add(new ArrayList<>(a));
        }
        // for(List<Integer>a:al) System.out.println(a);
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while(al.size() > 0) {
            int cur = rem;
            for(int i=0; i<al.size(); i++) {
                int val = al.get(i).remove(al.get(i).size()-1);
                cur += val;
                if(al.get(i).size() == 0) al.remove(i--);
            }
            // System.out.println(cur);
            // for(List<Integer>a:al) System.out.println(a);
            sb.insert(0, cur%10);
            rem = cur / 10;
        }
        if(rem != 0) sb.insert(0, rem);
        return sb.toString();
    }
}