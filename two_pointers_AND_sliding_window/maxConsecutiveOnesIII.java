public class maxConsecutiveOnesIII 
{
    public int BruteForce(int[] nums, int k) 
    {
        int n = nums.length;
        int maxlen=0;

        for(int i=0; i<n; i++)
        {
            int zeros = 0;
            for(int j=i; j<n; j++)
            {
                if(nums[j]==0)
                {
                    zeros++;
                }
                if(zeros<=k)
                {
                    int len = j-i+1;
                    maxlen = Math.max(maxlen, len);
                }
                else
                {
                    break;
                }
            }

        }
        return maxlen;
    }

    public int longestOnes(int[] nums, int k) 
    {
        int n = nums.length;
        int l=0, r=0, zeros=0, maxlen=0;

        while(r<n)
        {
            if(nums[r]==0)
            {
                zeros++;
            }
            
            while(zeros>k)
            {
                if(nums[l]==0)
                {
                    zeros--;
                }
                l++;
            }

            if(zeros<=k)
            {
                int len = r-l+1;
                maxlen = Math.max(maxlen, len);
            }

            r++;
        }

        return maxlen;
    }
}
