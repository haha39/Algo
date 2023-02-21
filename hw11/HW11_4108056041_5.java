public class HW11_4108056041_5 extends GroupCounting//weighted QU with path compression. no hash   quicksort  a = Integer.parseInt(A[i]);  arrays all have no  default
{
    /*public static void main(String[] args) 
    {
        String a[]  = { "9999","2","2","3","2","4","8","6"};
        String b[]  = { "5","5","3","4","4","5","6","11"};
        HW11_4108056041_5 test = new HW11_4108056041_5();
        int ans = test.count(a,b);
        System.out.println(ans);
    }*/
	public  int count(String[] A, String[] B)
    {
        int i,edge_num = A.length,node_num=1;
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
        weightedQuiCKfind ans = new weightedQuiCKfind(node_num);
        
        for(i=0;i<edge_num;i++)//union ing
        {
            ans.Weigthed_Union(arr[Integer.valueOf(A[i])], arr[Integer.valueOf(B[i])]);
        }

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

}
