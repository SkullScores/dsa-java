import java.util.Arrays;

public class climbingStairs 
{
    // Memoization
    public int f(int n, int[] dp)
    {
        if(n==0 || n==1)
        {
            return 1;
        }

        if(dp[n]!=-1) return dp[n];

        int left = f(n-1,dp);
        int right = f(n-2,dp);

        return dp[n]=left+right;
    }

    public int climbStairs(int n) 
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return f(n,dp);
    }

    // Tabulation
    public int g(int n, int[] dp)
    {
        // edge cases: if n=1/0
        if(n<=1)
        {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++)
        {
            // I can either come 1 step from stair i-1 OR 2 steps from stair i-2
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
