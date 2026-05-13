// TUF - Union of Two Sorted Arrays
// Approach: 2 pointers, skip duplicates by checking last added element
// Time: O(n + m) | Space: O(n + m)

class Solution 
{
    public int[] unionArray(int[] nums1, int[] nums2) 
    {
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                if(arr.size()==0 || arr.get(arr.size()-1)!=nums1[i])
                {
                    arr.add(nums1[i]);
                }
                i++;
            }
            else if(nums1[i]==nums2[j])
            {
                if(arr.size()==0 || arr.get(arr.size()-1)!=nums1[i])
                {
                    arr.add(nums1[i]);
                }
                i++;
                j++;
            }
            else
            {
                if(arr.size()==0 || arr.get(arr.size()-1)!=nums2[j])
                {
                    arr.add(nums2[j]);
                }
                j++;
            }
        }

        while(i < nums1.length)
        {
            if(arr.size()==0 || arr.get(arr.size()-1)!=nums1[i])
            {
                arr.add(nums1[i]);
            }
            i++;
        }

        while(j < nums2.length)
        {
            if(arr.size()==0 || arr.get(arr.size()-1)!=nums2[j])
            {
                arr.add(nums2[j]);
            }
            j++;
        }

        int[] unionArr = new int[arr.size()];

        for(int k=0; k<arr.size(); k++)
        {
            unionArr[k] = arr.get(k);
        }

        return unionArr;
    }
}