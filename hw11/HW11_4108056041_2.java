public class HW11_4108056041_2 extends GroupCounting//quick union timeout haha
{
    /*public static void main(String[] args) 
    {
        String a[]  = { "9999","2","2","3","2","4","8","6"};
        String b[]  = { "5","5","3","4","4","5","6","11"};
        HW11_4108056041_2 test = new HW11_4108056041_2();
        int ans = test.count(a,b);
        System.out.println(ans);
    }*/
	public  int count(String[] A, String[] B)
    {
        int i,edge_num = A.length,node_num=0;
        int arr[] = new int[2000000];//
        for(i=0;i<edge_num;i++)
        {
            if(arr[Integer.valueOf(A[i])] == 0)
            {
                arr[Integer.valueOf(A[i])] = node_num;
                node_num++;
            }
            if(arr[Integer.valueOf(B[i])] == 0)
            {
                arr[Integer.valueOf(B[i])] = node_num;
                node_num++;
            }
        }

        QuiCKfind ans = new QuiCKfind(node_num);
        
        for(i=0;i<edge_num;i++)//union ing
        {
            ans.union(arr[Integer.valueOf(A[i])], arr[Integer.valueOf(B[i])]);
        }

        ans.sort();//sorted
        int ct=0;
        int tmp = ans.find(0);
        ct++;
        for(i=1;i<node_num;i++)
        {
            if(ans.find(i) != tmp)
            {
                tmp = ans.find(i);
                ct++;
            }
        }
        return ct;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class QuiCKfind
    {
        private int[] array;
        private int arr_len;
        public QuiCKfind(int len)
        {
            array = new int[len];
            arr_len = len;
            for(int i=0;i<len;i++)
            {
                array[i] = i;
            }
        }

        public int find(int p)
        {
            return array[p];
        }

        public void union(int p,int q)
        {
            int pid = array[p];
            int qid = array[q];
            for(int i=0;i<array.length;i++)
            {
                if(array[i] == pid)
                    array[i] = qid;
            }
        }
        public void sort()
        {
            QuickSort(array, 0, arr_len-1);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void QuickSort(int[] arr,int left,int right/*,int index*/)
    {
        if (right <= left)
        return ;
        int pivotindex = (left + right)/2,i;
        int pivot = arr[pivotindex];
        Swap(arr,pivotindex,right);
        int swapindex = left;
        
        for (i = left; i < right;i++)
        {
            if (arr[i] < pivot)
            {
                Swap(arr, i, swapindex);
                ++swapindex;
            }
        }
        Swap(arr, swapindex, right);
        QuickSort(arr, left, swapindex - 1);
        QuickSort(arr, swapindex + 1, right);
    }
    public void Swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
