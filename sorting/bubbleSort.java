package sorting;

// Bubble Sort: Select minimums & swap
public class bubbleSort 
{
    public int[] bubbleSort_array(int[] arr)
    {
        int n = arr.length;

        for(int i=0; i<=n-2; i++)
        {
            int minIndex = i;
            //select minimum in remaining array
            for(int j=i+1; j<n; j++)
            {
                if(arr[j]<arr[minIndex])
                {
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }

        return arr;
    }
}
