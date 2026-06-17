// package DP;
import java.util.*;

public class RecursionL6 
{

    public static void printF(int idx, List<Integer> ds, int[] arr, int n)
    {
        // Base case: when we have traversed the entire array
        if(idx>=n)
        {
            if(ds.size()==0)
            {
                System.out.println("{}");
            }
            else
            {
                System.out.println(ds);
            }
            return;
        }
        

        // 1. take or pick the particular index into the subsequence
        ds.add(arr[idx]);
        printF(idx+1,ds,arr,n);
        
        // Backtrack: remove the last added element using its index
        ds.remove(ds.size()-1);

        // 2. not pick, or not take condition, this element is not added to your subsequence
        printF(idx+1,ds,arr,n);
    }

    public static void main(String[] args) 
    {
        int[] arr = {3,1,2};
        int n = arr.length;
        // Fix: Initialized the list
        List<Integer> ds = new ArrayList<>();

        printF(0,ds,arr,n);
    }
}


