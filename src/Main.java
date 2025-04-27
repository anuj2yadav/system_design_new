public class Main {
    public static void main(String[] args) {
       System.out.println(count("1",0));
    }
    public static String count(String n ,int idx)
    {
        if(idx>=n.length()) return "";

        char ch= n.charAt(idx);
        int count=0;
        // System.out.println(n.length()+"idx"+idx);
        while(idx<n.length() && ch==n.charAt(idx))
        {
            idx++;
            count++;
        }

        return count+(ch-'0')+count(n,idx);


    }
}