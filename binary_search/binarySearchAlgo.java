// LC 704 - Binary Search
// Approach: Iterative (low/high/mid pointers) + Recursive (divide search space)
// Time: O(log n) | Space: O(1) iterative, O(log n) recursive (call stack)

package binary_search;

public class binarySearchAlgo 
{

    //Iterative Code
    public int binarySearchIterative(int[] arr, int target) 
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high) //until search space is there
        {
            int mid = (low+high)/2;
            
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(target > arr[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }

    //Recursive Code
    public int binarySearchRecursive(int[] arr, int low, int high, int target)
    {
        //Base case: stops when search space exhausted
        if(low > high)
        {
            return -1;
        }

        int mid = (low+high)/2;

        if(arr[mid]==target)
        {
            return mid;
        }
        else if(target > arr[mid])
        {
            return binarySearchRecursive(arr, mid+1, high, target);
        }
        //adding else would be redundant bcoz all other cases have already been covered with early returns
        return binarySearchRecursive(arr, low, mid-1, target);
    }
}
