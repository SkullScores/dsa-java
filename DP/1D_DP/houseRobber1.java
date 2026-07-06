import java.util.*;


public class houseRobber1 
{
    public int f(int i, int[] nums)
    {
        int n=nums.length;
        if(i>=n)
        {
            return 0; //no houses left
        }

        int take = nums[i]+f(i+2,nums);
        int notTake = f(i+1,nums);

        return Math.max(take, notTake);
    }

    public int memo(int i, int[] dp, int[] nums)
    {
        // memo: max money I can rob from i to n-1 (end)
        int n=nums.length;
        if(i>=n)
        {
            return 0; //no houses left
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }

        int take = nums[i]+memo(i+2,dp,nums);
        int notTake = memo(i+1,dp,nums);

        return dp[i] = Math.max(take, notTake);
    }

    public int tab(int[] nums)
    {
        // dp[i]: max money I can rob from i to n-1

        int n = nums.length;

        int[] dp = new int[n+2];
        // n+2 so that dp[i+1] & dp[i+2] are always valid

        dp[n-1]=nums[n-1]; //only one house left, take it
        if(n>1) dp[n-2]= Math.max(nums[n-1],nums[n-2]); //better of last 2

        for(int i=n-3; i>=0; i--)
        {
            int take = nums[i]+dp[i+2];
            int notTake = 0+dp[i+1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[0]; // max money from 0 to end i.e. whole array
    }
    // n+2 size means dp[n] & dp[n+1] auto-initialize to 0 which is correct bcoz there aren't any houses there

    public int space_optimized(int[] nums)
    {
        int n = nums.length;

        if(n==1) return nums[0];

        int next2 = nums[n-1]; //dp[n-1]
        int next1 = Math.max(nums[n-1],nums[n-2]); //dp[n-2]

        for(int i=n-3; i>=0; i--)
        {
            int take = nums[i]+next2;
            int notTake = next1;

            int curri = Math.max(take, notTake);

            next2 = next1;
            next1 = curri;
        }
        return next1;
    }

    public int rob(int[] nums) 
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return memo(0,dp,nums);
    }
}
