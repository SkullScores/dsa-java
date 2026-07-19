import java.util.*;

public class fourSum2 
{
    public static long Brute_and_Optimized(int[] A, int[] B, int[] C, int[] D) 
    {
        int n = A.length;
        int cnt=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            if(!map.containsKey(D[i]))
            {
                map.put(D[i],1);
            }
            else
            {
                map.put(D[i], map.get(D[i])+1);
            }
        }
        // now I have frequencies of D[l]
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<n; k++)
                {
                    int result = 0 - (A[i]+B[j]+C[k]);
                    
                    if(map.containsKey(result))
                    {
                        cnt=cnt+map.get(result);
                    }
                }
            }
        }
        
        return cnt;
    }

    public static long MITM_soln(int[] A, int[] B, int[] C, int[] D)
    {
        int n = A.length;
        
        //Can I store all possible pair sums of A & B and use MITM?
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int sum = A[i]+B[j];
                if(!map.containsKey(sum))
                {
                    map.put(sum,1);
                }
                else
                {
                    map.put(sum,map.get(sum)+1);
                }
            }
        }
        // Now I have solved left half & stored all possible results
        
        int cnt = 0;
        
        for(int k=0; k<n; k++)
        {
            for(int l=0; l<n; l++)
            {
                int sum = -(C[k]+D[l]);
                
                if(map.containsKey(sum))
                {
                    cnt+=map.get(sum);
                }
            }
        }
        
        return cnt;
    }
}
