package stacks;

import java.util.HashMap;
import java.util.Stack;

public class NGE1_2arrays 
{
    // we can define NGE function for nums2 & then linearly search for nums1[i]==nums2[j] again & assign ans[i]=NGE[j]. But that takes TC: O(n + m.n).
    // We want lookup to be O(1)
    // therefore, best is HASHMAP

    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--)
        {
            while(!s.isEmpty() && s.peek()<=nums2[i])
            {
                s.pop();
            }
            int nge = s.isEmpty() ? -1 : s.peek();
            map.put(nums2[i], nge);
            s.push(nums2[i]);
        }
        
        int[] ans = new int[nums1.length];

        for(int i=0; i<nums1.length; i++)
        {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
