public class HW10_4108056041_4 extends SortingArray//quick sort
{
    /*public static void main(String[] args) 
    {
        int a[]  = {-1,2,5,9,8,7,1,3,2};
        HW10_4108056041_1 test = new HW10_4108056041_1();
        int ans[] = test.sorting(a);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    } */
	public  int[] sorting(int[] A)
    {
        QuickSort(A, 0, A.length-1);
        return A;
    }
    public void QuickSort(int[] arr,int left,int right)
    {
        if (right <= left)
        return ;
        int pivotindex = (left + right)/2,i;
        int pivot = arr[pivotindex];
        int temp = arr[pivotindex];
        arr[pivotindex] = arr[right];
        arr[right] = temp;
        int swapindex = left;
        for (i = left; i < right;i++)
        {
            if (arr[i] < pivot)
            {
                temp = arr[i];
                arr[i] = arr[swapindex];
                arr[swapindex] = temp;
                ++swapindex;
            }
        }
        temp = arr[swapindex];
        arr[swapindex] = arr[right];
        arr[right] = temp;
        QuickSort(arr, left, swapindex - 1);
        QuickSort(arr, swapindex + 1, right);
    }
}
