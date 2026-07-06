package Grids_DP;
import java.util.*;

class Solution 
{
    // Recursion

    public int f(int day, int last, int[][] matrix)
    {
        // base case: if(day==no of rows) rtn 0;
        if(day==matrix.length) return 0;

        int max = 0;

        // task = j
        for(int j=0; j<3; j++)
        {
            if(j!=last)
            {
                max = Math.max(max, matrix[day][j]+f(day+1,j,matrix));
            }
        }
        return max;
    }

    public int ninjaTraining(int[][] matrix) 
    {
        //use dummy value like 3
        // 0 != 3
        // 1 != 3
        // 2 != 3 therefore there was no previous activity before day 0 & we can choose any task
        return f(0,3,matrix);
    }

    // Memoization
    public int memo(int i, int last, int[][] dp, int[][] matrix)
    {
        // base case: if(day==no of rows) rtn 0;
        if(i==matrix.length) return 0;
        if(dp[i][last] != -1) return dp[i][last];

        int max = 0;

        // task = j
        for(int j=0; j<3; j++)
        {
            if(j!=last)
            {
                max = Math.max(max, matrix[i][j]+f(i+1,j,matrix));
            }
        }
        return dp[i][last] = max;
    }

    public int memo_main(int[][] matrix) 
    {
        int[][] dp = new int[matrix.length][4];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }

        return memo(0,3,dp,matrix);
    }

    // Striver's Tabulation

    // dp[day][last] as:
    // maximum points obtainable from day 0 to day, if on the current day we are forbidden from doing activity last

    public int tab(int[][] matrix)
    {
        int n = matrix.length;
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(dp[0][0], Math.max(dp[0][1],dp[0][2]));
        
        for(int day=1; day<n; day++)
        {
            // for every day, there are 4 different task values
            for(int last=0; last<4; last++)
            {
                // Now just copy paste the recursion part
                dp[day][last] = 0;

                for(int task=0; task<3; task++)
                {
                    if(task!=last)
                    {
                        dp[day][last] = Math.max(dp[day][last], matrix[day][task]+dp[day-1][task]);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    // Space Optimization
    public int space_optimized(int[][] matrix)
    {
        int n = matrix.length;
        // I'll make the first 4 array
        int[] prev = new int[4];

        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(dp[0], Math.max(dp[1],dp[2]));
        
        for(int day=1; day<n; day++)
        {
            // for every day, there are 4 different task values
            int[] temp = new int[4];
            for(int last=0; last<4; last++)
            {
                // Now just copy paste the recursion part
                temp[last] = 0;

                for(int task=0; task<3; task++)
                {
                    // in a way temp stores dp[day] i.e. the day
                    if(task!=last)
                    {
                        temp[last] = Math.max(temp[last], matrix[day][task]+prev[task]);
                    }
                }
                prev = temp;
            }
        }
        return prev[3];
    }
}
