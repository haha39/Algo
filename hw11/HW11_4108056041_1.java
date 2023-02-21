public class HW11_4108056041_1 extends GroupCounting//weighted QU with path compression. no hash   quicksort  a = Integer.parseInt(A[i]);  arrays all have no  default
{
    /*public static void main(String[] args) 
    {
        String a[]  = { "9999","2","2","3","2","4","8","6"};
        String b[]  = { "5","5","3","4","4","5","6","11"};
        HW11_4108056041_1 test = new HW11_4108056041_1();
        int ans = test.count(a,b);
        System.out.println(ans);
    }*/
	public  int count(String[] A, String[] B)
    {
        int i,edge_num = A.length,node_num=1;
        int arr[] = new int[2000000];//
        for(i=0;i<edge_num;i++)
        {
            if(arr[Integer.parseInt(A[i])] == 0)
            {
                arr[Integer.parseInt(A[i])] = node_num;
                node_num++;
            }
            if(arr[Integer.parseInt(B[i])] == 0)
            {
                arr[Integer.parseInt(B[i])] = node_num;
                node_num++;
            }
        }
        weightedQuiCKfind ans = new weightedQuiCKfind(node_num);
        
        for(i=0;i<edge_num;i++)//union ing
        {
            ans.Weigthed_Union(arr[Integer.parseInt(A[i])], arr[Integer.parseInt(B[i])]);
        }
        //change id to their root , than sort , then find island number
        /*int island_num = 0;
        for(i=0;i<node_num;i++)//change id to their root 
        {
            ans.change(i);
        }

        ans.sort();//sorted

        //find island number
        int tmp = ans.find(0);
        island_num++;
        for(i=1;i<node_num;i++)
        {
            if(ans.find(i) != tmp)//new island
            {
                tmp = ans.find(i);
                island_num++;
            }
        }*/
        int answer = ans.find_num();
        return answer;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class weightedQuiCKfind
    {
        private int[] array;
        private int arr_len;
        private int size[];
        public weightedQuiCKfind(int len)
        {
            array = new int[len];
            size = new int[len];
            arr_len = len;
            for(int i=1;i<len;i++)
            {
                size[i]=1;
                array[i] = i;
            }
        }

        public int find(int p)
        {
            while(p != array[p])
            {
                array[p] = array[array[p]];
                p = array[p];
            }
            return p;
        }

        public void Weigthed_Union(int p,int q)
        {
            int proot = find(p);
            int qroot = find(q);

            if(size[proot] < size[qroot])
            {
                array[proot] = qroot;
                size[qroot] += size[proot];
            }
            else
            {
                array[qroot] = proot;
                size[proot] += size[qroot];
            }
            
        }

        /*public void change(int j)//let their id become their root
        {
            array[j] = find(j);
        }

        public void print()
        {
            for(int i=0;i<arr_len;i++)
            {
                System.out.println(array[i]);
            }
        }
        public void sort()
        {
            QuickSort(array, 0, arr_len-1);
        }*/

        public int find_num()
        {   
            int count1=0,i;
            for(i=1;i<arr_len;i++)
            {
                if(array[i] == i)
                    count1++;
            }
            return count1;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*public void QuickSort(int[] arr,int left,int right)
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
    }*/
}
