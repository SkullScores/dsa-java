// package DP;
import java.util.*;

public class RecursionL7 
{
    public static void printS(int idx, List<Integer> ds, int s, int sum, int[] arr, int n)
    {
        if(idx==n)
        {
            if(s==sum)
            {
                System.out.println(ds);
            }
            return;
        }

        ds.add(arr[idx]);
        s+=arr[idx];

        printS(idx+1,ds,s,sum,arr,n);

        s-=arr[idx];
        ds.remove(ds.size()-1);

        //not pick
        printS(idx+1,ds,s,sum,arr,n);
    }

    public static boolean printS_2(int idx, List<Integer> ds, int s, int sum, int[] arr, int n)
    {
        if(idx==n)
        {
            //condition satisfied
            if(s==sum)
            {
                System.out.println(ds);
                return true;
            }
            //condition not satisfied
            else return false;
        }

        ds.add(arr[idx]);
        s+=arr[idx];

        if(printS_2(idx+1,ds,s,sum,arr,n) == true)
        {
            return true;
        }

        s-=arr[idx];
        ds.remove(ds.size()-1);

        //not pick
        if(printS_2(idx+1,ds,s,sum,arr,n) == true)
        {
            return true;
        }

        return false;
    }

    public static int printS_3(int idx, int s, int sum, int[] arr, int n)
    {
        // condition not satisfied
        // strictly done if array contains positives only
        if(s>sum) return 0;

        if(idx==n)
        {
            //condition satisfied
            if(s==sum) return 1;
            //condition not satisfied
            else return 0; //stating that this subsequence cannot be the part of your answer
        }

        s+=arr[idx];

        int l = printS_3(idx+1,s,sum,arr,n);

        s-=arr[idx];

        // not pick
        int r = printS_3(idx+1,s,sum,arr,n);

        return l+r;
    }

    public static void main(String[] args) 
    {
        int[] arr = {1,2,1};
        int n = arr.length;
        int sum = 2;

        List<Integer> ds = new ArrayList<>();

        printS(0,ds,0,sum,arr,n);
        System.out.println();

        printS_2(0,ds,0,sum,arr,n);

        System.out.println(printS_3(0,0,sum,arr,n));
    }
}
