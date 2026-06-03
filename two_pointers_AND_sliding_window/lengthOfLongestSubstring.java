package two_pointers_AND_sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring 
{
    public int lengthOfLongestSubstring_optimal(String s)
    {
        int n = s.length();
        int l=0;
        int r=0;
        int maxLen=0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(r<n)
        {
            char ch = s.charAt(r);

            if(map.containsKey(ch) && map.get(ch)>=l) //within l to r (within range))
            {
                l = map.get(ch)+1;
            }
            maxLen = Math.max(maxLen, r-l+1);
            map.put(ch,r); //also takes care of updates if in map but not in l to r range (index updated automatically)
            r++;
        }
        return maxLen;
    }
}

class Brute_Force_Soln
{
    public int BruteForce(String s) 
    {
        int maxLen = 0;
        int n = s.length();

        for(int i=0; i<n; i++)
        {
            HashSet<Character> set = new HashSet<>();

            for(int j=i; j<n; j++)
            {
                Character ch = s.charAt(j);

                if(set.contains(ch))
                {
                    break;
                }
                set.add(ch);
                maxLen = Math.max(maxLen, set.size());
            }
        }
        return maxLen;
    }
}
