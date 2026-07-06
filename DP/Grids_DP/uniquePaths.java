package Grids_DP;
import java.util.*;

class Solution 
{
    // Recursion
    public int f(int i, int j)
    {
        if(i==0 && j==0)
        {
            return 0;
        }

        if(i<0 || j<0)
        {
            return 0;
        }

        int up = f(i-1,j);
        int left = f(i,j-1);

        return up+left;
    }

    public int memo(int i, int j, int[][] dp)
    {
        if(i==0 && j==0)
        {
            return 0;
        }

        if(i<0 || j<0)
        {
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int up = f(i-1,j);
        int left = f(i,j-1);

        return dp[i][j] = up+left;
    }

    public int tab(int m, int n, int[][] dp)
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0) dp[0][0] = 1;
                else
                {
                    int up=0, left=0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int space_optimized(int m, int n)
    {
        // Array for the previous row
        int[] prev = new int[n]; // length is no of columns

        //Iterate through the rows
        for(int i=0; i<m; i++)
        {
            // Array for the current row
            int[] curr = new int[n];

            for(int j=0; j<n; j++)
            {
                // Base case
                if(i==0 && j==0) curr[j] = 1;
                
                else
                {
                    int up=0, left=0;
                    if(i>0) up = prev[j];
                    if(j>0) left = curr[j-1];
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

    public int uniquePaths(int m, int n) 
    {
        return f(m-1,n-1);

        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return memo(m-1,n-1,dp);

    }
}
