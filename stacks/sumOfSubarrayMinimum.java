package stacks;
import java.util.*;


class Solution 
{
    public int sumSubarrayMins_Brute1(int[] arr) 
    {
        int n = arr.length;
        long sum = 0;

        for(int i=0; i<n; i++)
        {
            Stack<Integer> s = new Stack<>();
            for(int j=i; j<n; j++)
            {
                while(!s.isEmpty() && s.peek()>arr[j])
                {
                    s.pop();
                }

                if(s.isEmpty())
                {
                    s.push(arr[j]);
                    sum = sum + s.peek();
                }
                else
                {
                    sum = sum + s.peek();
                }
            }
        }
        int MOD = 1000000007;
        return (int)(sum % MOD);
    }


    public int sumSubarrayMins_Brute2(int[] arr) 
    {
        int n = arr.length;
        long sum = 0;

        for(int i=0; i<n; i++)
        {
            int currentMin = Integer.MAX_VALUE;

            for(int j=i; j<n; j++)
            {
                currentMin = Math.min(currentMin, arr[j]);
                sum += currentMin;
            }
        }
        int MOD = 1000000007;
        return (int)(sum % MOD);
    }

}

// Most Optimal soln: O(5n), O(5n) -> uses PSE & NSE (monotonic stack)
class Most_Optimal_Solution 
{
    private int[] findNSE(int[] arr)
    {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
            {
                s.pop();
            }
            nse[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        return nse;
    }

    private int[] findPSEE(int[] arr)
    {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()]>arr[i])
            {
                s.pop();
            }
            psee[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return psee;
    }

    public int sumSubarrayMins(int[] arr) 
    {
        int n = arr.length;

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        int mod = (int)1e9 + 7;
        int total = 0;

        for(int i=0; i<n; i++)
        {
            int left = i-psee[i]; // Count of elements to the left including current
            int right = nse[i] - i; // Count of elements to the right including current

            // Total subarrays where arr[i] is the minimum
            long freq = left * right * 1L;

            // Contribution = frequency * value
            int val = (int)(freq * arr[i] % mod);

            total = (total + val) % mod;
        }
        return total;
    }
}
