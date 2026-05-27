package stacks;
import java.util.*;

class Solution 
{
    // Brute force: search in rotated circular array
    // Hypothetically, maintain a double array

    public int[] nextGreaterElements_BruteForce(int[] arr) 
    {
        int n = arr.length;
        int[] NGE = new int[n];

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<=i-n+1; j++)
            {
                int idx = j % n;
                if(arr[idx] > arr[i])
                {
                    NGE[i] = arr[idx];
                    break;
                }
                else
                {
                    NGE[i] = -1;
                }
            }
        }
        return NGE;
    }

    // Better: monotonic stack on double virtual array BUT nge[i] only counted for i<n

    public int[] nextGreaterElements(int[] arr) 
    {
        int n = arr.length;
        int[] NGE = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=2*n-1; i>=0; i++)
        {
            while(!s.isEmpty() && s.peek()<=arr[i%n])
            {
                s.pop();
            }

            if(i<n)
            {
                NGE[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(arr[i%n]);
        }

        return NGE;
    }
}