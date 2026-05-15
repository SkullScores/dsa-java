// Lower Bound
// Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
// The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
// If no such index is found, return the size of the array.

class LowerBound 
{
    public int lowerBound(int[] arr, int x) 
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = arr.length;

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid]>=x)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
}

// Upper Bound
// Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
// The upper bound of x is defined as the smallest index i such that nums[i] > x.
// If no such index is found, return the size of the array.

class UpperBound
{
    public int upperBound(int[] arr, int x) 
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = arr.length;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]<=x)
            {
                low = mid+1;
            }
            else
            {
                ans = mid;
                high = mid-1;
            }
            return ans;
        }
    }
}