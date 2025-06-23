public class Leetcode {


    public static void main(String [] arsg)
    {
        int [][] board =new int [][]{{-1,-1},{-1,3}};
        int row=board.length;
        // if even
        dfs(board,1,row);
    }
    public static int dfs(int [][] board,int number,int n)
    {
        if(number>=n*n) return 0;

        int ans=100000;

        for(int i=1;i<=6;i++)
        {
            int newNumber=number+i;
            if(newNumber>n*n) continue;
            int row=(int)Math.ceil((double)newNumber/n)-1;
            int col=0;
            int rem=newNumber%n;
            if(row%2==0)
            {

                col=rem;
            }
            else
            {
                //col=0;
                col=n-rem-1;
            }
            if(board[row][col]==-1)
            {
                ans=Math.min(ans,1+dfs(board,newNumber,n));
            }
            else{
                ans=Math.min(ans,1+dfs(board,board[row][col],n));
            }


        }
        return ans;

    }

}
