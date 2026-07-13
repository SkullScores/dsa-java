package Graphs.BFS.DFS;
import java.util.*;

public class cycle_undirectedGraph_DFS 
{
    public boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;

        for(it : adj.get(node))
        {
            if(vis[it]==0)
            {
                if(dfs(it,node,vis,adj)==true)
                {
                    return true;
                }
            }
            else if(parent!=it)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];

        for(int i=0; i<V; i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,-1,vis,adj)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
