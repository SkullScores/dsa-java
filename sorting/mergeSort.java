package sorting;

import java.util.ArrayList;

public class mergeSort 
{
    public void mergeSort_array(int[] arr, int low, int high)
    {
        if(low>=high)
        {
            return;
        }

        int mid = low + (high-low)/2;

        mergeSort_array(arr, low, mid);
        mergeSort_array(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private int[] merge(int[] arr, int low, int mid, int high)
    {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else
            {
                temp.add(arr[right]);
                right++;
            }
        }

        //while can get exhausted in 2 ways: either left remains OR right remains
        while(left<=mid)
        {
            temp.add(arr[left]);
            left++;
        }

        while(right<=high)
        {
            temp.add(arr[right]);
            right++;
        }

        // Now I have merged elements in a 3rd collection... I want it in OG array
        for(int i=low; i<=high; i++)
        {
            arr[i] = temp.get(i-low);
        }
        return arr;
    }
}
