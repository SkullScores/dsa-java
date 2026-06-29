import java.util.*;

public class frogJumpWithKdistances 
{
    // recursion
    public int f(int ind, int[] arr, int k)
    {
        if(ind==0) return 0;

        int minJump = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++)
        {
            // only valid jumps will matter.. so I'll need to check if ind-i>=0
            if(ind-i>=0)
            {
                int jump = f(ind-i,arr,k) + Math.abs(arr[ind]-arr[ind-i]);
                minJump = Math.min(jump, minJump);
            }
        }
        return minJump;
    }

    //memoization
    public int memo(int ind, int[] dp, int[] arr, int k)
    {
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int minJump = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++)
        {
            // only valid jumps will matter.. so I'll need to check if ind-i>=0
            if(ind-i>=0)
            {
                int jump = memo(ind-i,dp,arr,k) + Math.abs(arr[ind]-arr[ind-i]);
                minJump = Math.min(jump, minJump);
            }
        }
        return dp[ind] = minJump;
    }

    // tabulation
    public int tab(int ind, int[] arr, int[] dp)
    {
        int n = arr.length;
        dp[0] = 0;

        for(int i=0; i<n; i++)
        {
            int minJump = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++)
            {
                if(j-i>=0)
                {
                    int jump = dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    minJump = Math.min(jump, minJump);
                }
            }
            dp[i] = minJump;
        }

        return dp[n-1];
    }

    public int frogJump(int[] heights, int k)
    {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        tab(n-1, heights, dp);
    }
}
