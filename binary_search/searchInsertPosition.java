package binary_search;

// Given a sorted array of distinct integers and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

public class searchInsertPosition 
{
    public int searchInsert(int[] arr, int target) 
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return low; //NOT -1!
    }
}
