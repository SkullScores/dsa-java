package Graphs.BFS.DFS;
import java.util.*;

class Solution 
{
    public int findNumberOfComponent(int V, List<List<Integer>> edges) 
    {
        //Make an adjacency list using edges

        //1. Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        //2. fill it
        for(List<Integer> edge : edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // use it to use no of provinces
        int[] vis = new int[V];
        int cnt=0;
        for(int i=0; i<V; i++)
        {
            if(vis[i]==0)
            {
                cnt++;
                dfs(i,adj,vis);
            }
        }
        
        return cnt;
    }

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
}
