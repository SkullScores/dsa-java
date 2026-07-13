package Graphs.BFS.DFS;
import java.util.*;

class Solution 
{
    public class Pair
    {
        int node;
        int parent;

        Pair(int node, int parent)
        {
            this.node=node;
            this.parent=parent;
        }
    }

    public boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, int[] vis)
    {
        vis[src]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));

        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            for(it : adj)
            {
                if(vis[it]==0)
                {
                    vis[it]=1;
                    q.add(new Pair(it,node));
                }
                else if(parent!=it) // I found a visited neighbour BUT its not the node I came from
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) 
    {
        int[] vis = new int[V];
        // to check all components of the graph, just apply no of provinces

        for(int i=0; i<V; i++)
        {
            if(vis[i]==0)
            {
                if(detectCycle(i,adj,vis)) return true;
            }
        }

        return false;

    }
}
