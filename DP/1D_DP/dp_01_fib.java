import java.util.*;

public class dp_01_fib
{
    public int f(int n, int[] dp)
    {
        if(n<=1)
        {
            return n;
        }

        if(dp[n]!=-1)
        {
            return dp[n];
        }

        return dp[n] = f(n-1,dp)+f(n-2,dp);
    }

    public int fib(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return f(n, dp);
    }


    // pure recursion
    public int fib(int n)
    {
        if(n<=1)
        {
            return n;
        }

        return fib(n-1)+fib(n-2);
    }

    // memoization
    public int fib_memo(int n, int[] dp)
    {
        if(n<=1)
        {
            return n;
        }

        if(dp[n]!=-1) return dp[n];

        return dp[n] = fib(n-1,dp)+fib(n-2,dp);
    }

    public int soln(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return fib_memo(n,dp);
    }

    // tabulation
    public int fib_tab(int n, int[] dp)
    {
        if(n<=1) return n;

        dp[0]=0; dp[1]=1;

        for(int i=2; i<=n; i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // Space optimized
    public int fib_space(int n)
    {
        if(n<=1)
        {
            return n;
        }

        int prev2 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++)
        {
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }

}