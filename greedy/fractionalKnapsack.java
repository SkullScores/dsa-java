package greedy;
import java.util.*;

public class fractionalKnapsack 
{
    public class Item
    {
        int val;
        int wt;

        Item(int val, int wt)
        {
            this.val=val;
            this.wt=wt;
        }
    }

    public class MyComparator implements Comparator<Item>
    {
        @Override
        public int compare(Item a, Item b)
        {
            double r1 = (double) a.val/ (double) a.wt;
            double r2 = (double) b.val/ (double) b.wt;
            return Double.compare(r2,r1);
        }
    }

    public double fractional_Knapsack(int[] val, int[] wt, long cap) 
    {
        Item[] items = new Item[val.length];

        for(int i=0; i<val.length; i++)
        {
            items[i] = new Item(val[i],wt[i]);
        }

        Arrays.sort(items, new MyComparator());

        double sum=0.000000;

        for(int i=0; i<items.length; i++)
        {
            if(items[i].wt<=cap)
            {
                sum+=items[i].val;
                cap-=items[i].wt;
            }
            else
            {
                double fraction = ((double) cap/items[i].wt);
                sum+= fraction*items[i].val;
                break;
            }
        }

        return sum;
    }
}
