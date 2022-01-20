/**
 * Merge Sort algorithm
 * (Nothing new here, literally just the regular algorithm sorter)
 * 
 * @author Vaughn Chan
 * @version 2022-01-19
 */
public class Sort
{
    public static int[] reverseMergeSort(int[] arr)
    {
        arr = mergeSort(arr);
        int[] revArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            revArr[i] = arr[arr.length - i - 1];
        }
        
        return revArr;
    }
    
    public static int[] mergeSort(int[] arr)
    {
        int[] temp = new int[arr.length];
        mergeSortHelper (arr, 0, arr.length - 1, temp);
        return arr;
    }
    
    private static void mergeSortHelper (int[] arr, int from, int to, int[] temp)
    {
        if (to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge (arr, from, mid, to, temp);
        }
    }
    
    private static void merge (int[] arr, int from, int mid, int to, int[] temp)
    {
        int i = from;
        int j = mid + 1;
        int k = from;
        
        while (i <= mid && j <= to)
        {
            if (arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        // Cleanup
        while (i <= mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }
        
        while (j <= to)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }
        
        // Copy over from temp to elements
        for (k = from; k <= to; k++)
        {
            arr[k] = temp[k];
        }
    }
}
