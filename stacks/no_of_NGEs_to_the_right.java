package stacks;
import java.util.*;

// Given an array of arr[] and Q queries of indices. For each query indices[i], 
// determine the count of elements in arr that are strictly greater than arr[indices[i]] to its right (after the position indices[i]).

// Examples :

// Input: arr[] = [3, 4, 2, 7, 5, 8, 10, 6], queries = 2, indices[] = [0, 5]
// Output:  [6, 1]
// Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6.
// The next greater elements to the right of 8(index 5) is only 10.

// Brute Force: TC=O(n^2)
public class no_of_NGEs_to_the_right 
{
    public static int[] count_NGE(int arr[], int indices[]) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<indices.length; i++)
        {
            int cnt = 0;
            for(int j=indices[i]+1; j<arr.length; j++)
            {
                if(arr[j]>arr[indices[i]])
                {
                    cnt++;
                }
            }
            result.add(cnt);
        }
        
        int[] ans = new int[result.size()];
        for(int k=0; k<ans.length; k++)
        {
            ans[k]=result.get(k);
        }
        return ans;
    }

    // VARIATION (Learning: ngeIndex calculation & using it in CHAINING)
    // Given an array, for each index find the count of elements reachable through the NGE chain starting at that index
    public static int[] chain_NGE(int[] arr)
    {
        Stack<Integer> s = new Stack<>();
        int[] ngeIndex = new int[arr.length];
        int n = arr.length;

        for(int i=n-1; i>=0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()]<=arr[i])
            {
                s.pop();
            }
            ngeIndex[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        int[] count = new int[arr.length];

        for(int i=n-1; i>=0; i--)
        {
            if(ngeIndex[i]==-1)
            {
                count[i]=0;
            }
            else
            {
                count[i] = 1 + count[ngeIndex[i]];
            }
        }

        return count;
    }
}

