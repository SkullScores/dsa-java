package Graphs.BFS.DFS;
import java.util.*;

class Solution 
{
    class Trio
    {
        int i;
        int j;
        int time;

        Trio(int i, int j, int time)
        {
            this.i=i;
            this.j=j;
            this.time=time;
        }
    }

    public int orangesRotting(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int fresh=0;

        Queue<Trio> q = new LinkedList<>();

        //Traverse to fill visited for t=0
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                if(grid[i][j]==2)
                {
                    q.add(new Trio(i,j,0));
                    vis[i][j]=2;
                }
            }
        }

        int maxTime=0;

        while(!q.isEmpty())
        {
            int i=q.peek().i;
            int j=q.peek().j;
            int time=q.peek().time;
            //have not coded change to rotten yet
            q.remove();

            //dirn arrays
            //U,D,L,R
            int[] dr = {-1,+1,0,0};
            int[] dc = {0,0,-1,+1};

            for(int k=0; k<=3; k++)
            {
                int nr=i+dr[k];
                int nc=j+dc[k];

                if(nr>=0 && nr<=m-1 && nc>=0 && nc<=n-1 && grid[nr][nc]==1)
                {
                    q.add(new Trio(nr,nc,time+1));
                    grid[nr][nc]=2;
                    fresh--;
                }
            }

            maxTime=Math.max(time,maxTime);
        }

        if(fresh!=0)
        {
            return -1;
        }

        return maxTime;
    }
}
