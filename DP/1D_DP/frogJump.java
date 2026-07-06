import java.util.*; 

public class frogJump 
{
    public int recurrence(int ind, int[] h) 
    {
        int n = h.length;
        if(n==0) return 0; // already here, spent nothing
        if(n==1) return Math.abs(h[1]-h[0]);

        int left = recurrence(ind-1, h) + Math.abs(h[i]-h[i-1]);
        // Its your job to tell me what's the energy from index-1 to 0, recursion will do that for you!
        int right = recurrence(ind-2, h) + Math.abs(h[i]-h[i-2]);

        return Math.min(left,right);
    }

    // memoization
    public int f(int idx, int[] h, int[] dp)
    {
        int n = h.length;
        if(n==0) return 0;
        if(n==1) return Math.abs(h[1]-h[0]);
        
        if(dp[idx]!=-1) return dp[idx];

        int left = f(idx-1,h,dp) + Math.abs(h[idx]-h[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx>1)
        {
            right = f(idx-2,h,dp) + Math.abs(h[idx]-h[idx-2]);
        }

        return dp[idx] = Math.min(left,right);
    }

    // Tabulation
    public int tab(int[] h)
    {
        int n = h.length;
        int[] dp = new int[n];

        dp[0] = 0;
        // works as idx>1
        if(n>1) dp[1] = Math.abs(h[1]-h[0]);

        for(int idx=2; idx<n; idx++)
        {
            dp[idx] = Math.min(dp[idx-1] + Math.abs(h[idx-1]-h[idx]), dp[idx-2] + Math.abs(h[idx-2]-h[idx]));
        }
        return dp[n-1];
    }

    public int frogJump(int[] heights)
    {
        int n = heights.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return f(n-1,heights,dp); //Array is 0-indexed (last valid index is n-1)
    }

    // Tabulation
    public int tab(int[] h)
    {
        int n = h.length;
        int[] dp = new int[n];

        dp[0] = 0;
        // works as idx>1
        if(n>1) dp[1] = Math.abs(h[1]-h[0]);

        for(int idx=2; idx<n; idx++)
        {
            dp[idx] = Math.min(dp[idx-1] + Math.abs(h[idx-1]-h[idx]), dp[idx-2] + Math.abs(h[idx-2]-h[idx]));
        }
        return dp[n-1];
    }

    // Space Optimized
    public int tab(int[] h)
    {
        int n = h.length;
        int[] dp = new int[n];

        // EDGE CASE!
        if(n==1) return 0;

        int prev2 = 0;
        int prev = Math.abs(h[1]-h[0]);

        for(int idx=2; idx<n; idx++)
        {
            int curri = Math.min(prev + Math.abs(h[idx-1]-h[idx]), prev2 + Math.abs(h[idx-2]-h[idx]));
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
