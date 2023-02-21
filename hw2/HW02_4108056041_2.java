public class HW02_4108056041_2 extends ThreeSum
{
    public static void main(String[] args) 
    {
        long start =System.currentTimeMillis();
        int[] B = {3575,1706,1,-1,2,3,4};
        HW02_4108056041_2 test = new HW02_4108056041_2();
        System.out.println(test.T_sum(B));
        
        long now =System.currentTimeMillis();
        System.out.println("time:"+(now-start)/1000.00);
    }
    public int  T_sum(int[] A)
    {
        QuickSort(A, 0, A.length-1);
        for(int i=0;i<A.length;i++)
        System.out.println(A[i]);

        int ans = 0,i,left,right,need;
        for(i=0;i<A.length-2;i++)
        {
            left = i+1;
            right = A.length-1;
            need = 0-A[i]; 
            while(left<right) 
            {
                //System.out.println(A[left]+"    "+A[right]+"    "+ans );
                if(A[left]+A[right] == need)
                {
                    ans++;
                    left++;
                    right--;
                }
                else if(A[left]+A[right]<need)
                    left++;
                else
                    right--;
            }
        }
        System.out.println(ans);
        return ans;
    }
    /*public void QuickSort(int[] arr)
    {
        QuickSort(arr,0,arr.length-1);
    }*/
    public void QuickSort(int[] arr,int left,int right)
    {
        if (right <= left)
        return;
        int pivotindex = (left + right)/2,i;
        int pivot = arr[pivotindex];
        Swap(arr,pivotindex,right);
        int swapindex = left;
        for (i = left; i < right;i++)
        {
            if (arr[i] <= pivot)
            {
                Swap(arr, i, swapindex);
                ++swapindex;
            }
        }
        Swap(arr, swapindex, right);
        QuickSort(arr, left, swapindex - 1);
        QuickSort(arr, swapindex + 1, right);
        /*for(i=0;i<arr.length;i++)
        {
            System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+arr[i]);
        }*/
    }
    public void Swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
