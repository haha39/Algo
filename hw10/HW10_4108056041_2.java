public class HW10_4108056041_2 extends SortingArray // IN PLACE quick sort
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
    }*/
	public  int[] sorting(int[] A)
    {
        QuickSort(A, 0, A.length);
        return A;
    }
    public void QuickSort(int[] arr,int left,int right)
    {
        if (right <= left)
        return ;
        int pivotindex = arr[right-1];
        int i;
        //int pos = left;
        //int pivot = arr[pivotindex];
        //Swap(arr,pivotindex,right);
        int swapindex = left;
        for (i = left; i < right-1;++i)
        {
            if (arr[i] < pivotindex)
            {
                Swap(arr, i, swapindex);
                swapindex++;
            }
        }
        Swap(arr, right-1, swapindex);
        QuickSort(arr, left, swapindex );
        QuickSort(arr, swapindex + 1, right);
    }
    public void Swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
