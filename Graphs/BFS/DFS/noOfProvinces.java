package Graphs.BFS.DFS;
import java.util.*;

// Initial Thinking
class Solution 
{
    class Pair
    {
        int i;
        int j;

        Pair(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        HashSet<Pair> set = new HashSet<>();
        int cnt = 0;
        int n = isConnected.length;

        for(int i=0; i<n; i++)
        {
            int isolated=0;

            for(int j=0; j<n; j++)
            {
                if(i==j && isConnected[i][j]==1) //only for isolated province
                {
                    isolated=1;
                    continue;
                }

                if(isConnected[i][j]==1 && !set.contains(new Pair(i,j)))
                {
                    cnt++;
                    isolated++;
                    set.add(new Pair(j,i));
                }

                if(set.contains(new Pair(i,j)) || set.contains(new Pair(j,i)))
                {
                    isolated++;
                    continue;
                }
            }

            if(isolated==1)
            {
                cnt++;
            }
        }

        return cnt;
    }
}
// Shortcomings:

// 1.
// set.contains(new Pair(i, j)) will always return false, because Pair doesn't override equals() and hashCode().
// Java compares object references by default.

// Pair p1 = new Pair(1, 2);
// Pair p2 = new Pair(1, 2);
// System.out.println(p1.equals(p2)); --> will return false!!

// 2.
// Your code would see
// (0,1)
// (1,2)
// and count two different connections.

// But provinces are connected components, not edges



class Solution 
{
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis)
    {
        vis[node]=1;

        for(int it : adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(it,adj,vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<V; i++)
        {
            for(int j=0; j<V; j++)
            {
                if(isConnected[i][j]==1 && i!=j)//no self nodes
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];

        int cnt=0;

        for(int i=0; i<vis.length; i++)
        {
            if(vis[i]==0)
            {
                cnt++;
                dfs(i,adj,vis);
            }
        }

        return cnt;
    }
}

