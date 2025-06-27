import java.util.*;
public class Main {
    public static void main(String[] args) {
        String s="1001010";
        int k=5;
        longestSubsequence(s,k);
    }

    public  static int longestSubsequence(String s, int k) {
        int sum=0;
        //  get the highest set but
        int bits=(int)(Math.log(k)/Math.log(2))+1;
        int count=0;
        // System.out.println(bits);
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(s.length()-1-i);
            System.out.println(ch);
            if(ch=='1')
            {
                if(i<bits && sum+ (1<<i)<=k)
                {
                    sum+=(1<<i);
                    count++;
                }
            }
            else
            {
                count++;
            }
        }
        return count;
    }
}