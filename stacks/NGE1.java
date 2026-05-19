package stacks;
import java.util.*;

public class NGE1 
{
    //Brute Force: TC(n1.n2+n2)
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int[] NGE = new int[nums1.length];

        for(int i=0; i<nums1.length; i++)
        {
            int index = -1;

            //search for nums1[i]==nums2[j]
            for(int j=0; j<nums2.length; j++)
            {
                if(nums1[i]==nums2[j])
                {
                    index=-1;
                    break;
                }
            }

            //Find NGE
            NGE[i] = -1;

            for(int k = index+1; k<nums2.length; k++)
            {
                if(nums2[k]>nums2[j])
                {
                    NGE[i]=nums2[k];
                    break;
                }
            }
            return NGE;
        }
    }

    //Monotonic Stack: Cleanest code
    public int[] NGE_1(int[] arr)
    {
        Stack<Integer> s = new Stack<>();
        int[] NGE = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--)
        {
            while(!s.isEmpty() && s.peek()<=arr[i])
            {
                s.pop();
            }
            NGE[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return NGE;
    }
}
