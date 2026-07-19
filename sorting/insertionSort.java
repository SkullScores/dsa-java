import java.util.*;

public class insertionSort 
{
    public void insertion_sort(int[] arr)
    {
        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            int j=i;

            while(j>0 && arr[j-1]>arr[j])
            {
                //swap
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }
}
