public class houseRobber2 
{
    // ans1 = leave first, apply funcn(1 to n-1)
    // ans2 = leave last, apply funcn(0 to n-2)
    // return max(ans1, ans2)

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

    public int rob(int[] nums) 
    {
        int n = nums.length;
        // edge case: if n==1, both subarrays will be empty
        if(n==1) return nums[0];

        int[] arr1 = new int[n-1];
        for(int i=0; i<=n-2; i++)
        {
            arr1[i] = nums[i];
        }

        int[] arr2 = new int[n-1];
        for(int i=1; i<=n-1; i++)
        {
            arr2[i-1] = nums[i];
        }

        int ans1 = tab(arr1);
        int ans2 = tab(arr2);

        return Math.max(ans1,ans2);
    }
}
