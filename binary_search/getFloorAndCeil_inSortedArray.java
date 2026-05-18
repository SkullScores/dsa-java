class Solution 
{
    public int[] getFloorAndCeil(int[] nums, int target) 
    {

        int n = nums.length;
        int[] ans = new int[2];
        int low = 0;
        int high = n-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                ans[0]=nums[mid];
                ans[1]=nums[mid];
                return ans;
            }
            else if(nums[mid]<target)
            {
                if(mid==n-1)
                {
                    ans[0]=nums[mid];
                    ans[1]=-1;
                    return ans;
                }
                low=mid+1;
            }
            else
            {
                if(mid==0)
                {
                    ans[0]=-1;
                    ans[1]=nums[mid];
                    return ans;
                }
                high = mid-1;
            }
        }
        ans[0] = nums[high];
        ans[1] = nums[low];
        return ans;
    }

    //Cleaner version
        // int n = nums.length;

        // int floor = -1;
        // int ceil = -1;

        // int low = 0;
        // int high = n-1;

        // while(low<=high)
        // {
        //     int mid = low + (high-low)/2;
        //     if(nums[mid]==target)
        //     {
        //         return new int[]{target, target};
        //     }
        //     else if(nums[mid]<target)
        //     {
        //         floor = nums[mid];
        //         low=mid+1;
        //     }
        //     else
        //     {
        //         ceil = nums[mid];
        //         high = mid-1;
        //     }
        // }
        
        // return new int[]{floor, ceil};

}