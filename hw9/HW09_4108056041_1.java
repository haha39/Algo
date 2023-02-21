import java.util.ArrayList;
//import java.util.Stack;
public class HW09_4108056041_1 extends LSD
{
    public static void main(String[] args) 
    {
        int a[][]  = { {0,1},{0,2},{0,4},{3,1},{4,1},{2,5},{60,7}};
        HW09_4108056041_1 test = new HW09_4108056041_1();
        int ans = test.Distance(a);
        System.out.println(ans);
    }
    public int Distance(int[][] arr)
    {
        int ans=123456,i,num=0,len=arr.length;
        //System.out.println(len);
        //to find num
        int arr_findnum[] = new int[len*2];
        for (i = 0; i < len; i++)
        {
            arr_findnum[2*i] = arr[i][0];
            arr_findnum[2*i+1] = arr[i][1];
            //System.out.println(arr_findnum[i]+" "+arr_findnum[i+1]+" "+arr[i][0]+" "+arr[i][1]);
        }
        QuickSort(arr_findnum, 0, (len*2)-1);
        
        for (i = 0; i < len*2; i++)
        {
            if(arr_findnum[i] != -1)
            {
                num++;
            }
        }
        //System.out.println("    ddddddddddddddddddddddd     "+num);

        Graph g = new Graph(num,arr_findnum);
        for (i = 0; i < len; i++)
        {
            g.addEdge(arr[i][0], arr[i][1]);
        }
        //find the bigest island
        



        int guess1 = 92*g.ans();
        guess1 = guess1/100;
        return guess1;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class Graph
    {
        private final int V;
        private Bag[] adj;
        public Graph(int V,int[] array)
        {
            this.V = V+1;
            adj =  new Bag[this.V];
            int v = 0,i;
            for (i = 0; i < array.length; i++)
            {
                if(array[i] != -1){
                    adj[v] = new Bag(array[i],v);
                    v++;
                }
            }
            /*for(int i = 0;i < V;i++){
                
                System.out.println(i+" "+adj[i].value);
            }*/
            
        }

        public void addEdge(int v, int w)
        {
            v = index(v);
            w = index(w);
            adj[v].add(w);
            adj[w].add(v);
        }
        public int index(int value)
        {
            int left = 0;
            int right = V;
            int mid = (left +right)/2;
            while(adj[mid].value != value)
            {
                if(value > adj[mid].value)
                {
                    left = mid;
                    mid = (left +right)/2;
                }
                else if(value < adj[mid].value)
                {
                    right = mid;
                    mid = (left +right)/2;
                }
            }
            return mid;
        }
        
        public int ans()
        {
            //find bigest_island
            int i,count=1,max_size=-1,tmp_size,max_ct=0;
            BreadthFirstPaths s =new BreadthFirstPaths();
            for(i=0;i<V-1;i++)
            {
                if(adj[i].mark == 0)
                {
                    //System.out.println(i+" "+adj[i].value+" "+adj[i].mark+"  "+adj[i].size()+"   "+ct); 
                    tmp_size=s.bfs_island(adj, i,count);
                    if( tmp_size>max_size)
                    {
                        max_size = tmp_size;
                        max_ct = count;
                    }
                    count++;
                    //System.out.println(max_size);
                    //private void bfs_island(Bag[] b, int s,int size) // bfs(adj, adj[i].mark,adj[i].size());
                }
            }
            /*for(i=0;i<V-1;i++)
            {
                System.out.println(i+" "+adj[i].mark+"  "+adj[i].value);
            } */
            //System.out.println(max_size+"    "+max_ct);
            //in bigest island, find avg_size, do bfs form node <= avg to other nodes
            int avg_size=0,j,max_edge=0,tmp_edge,k;
            for(i=0;i<V-1;i++)
            {
                if(adj[i].mark == max_ct)
                {
                    avg_size += adj[i].size();
                }
            }
            avg_size = avg_size/max_size;
            for(i=0;i<V-2;i++)
            {
                if( ( adj[i].size() <= avg_size)  && (adj[i].mark==max_ct)  )
                {
                    for(j=i+1;j<V-1;j++)
                    {
                        for(k=0;k<V-1;k++)
                        {
                            adj[k].mark = max_ct;
                        }
                        tmp_edge = s.bfs_path(adj, i, /*j,*/ max_ct);
                        if( tmp_edge>max_size)
                        {
                            max_edge = tmp_edge;
                        }
                    }
                }
            }
            //System.out.println(max_size+"    "+max_ct);
            return max_edge;
        }
    }
    public class Bag
    {
        int index;
        int value;
        int edge=0;
        int mark = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        public Bag(int value,int index)
        {
            this.value = value;
            this.index = index;
        }
        public void add(int a)
        {
            list.add(a);
            
        }
        public int size()
        {
            return list.size();
        }
        public int getindex(int x)
        {
            return list.get(x);
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
            else if(arr[i] == pivot)
            {
                arr[i] = -1;
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class BreadthFirstPaths
    {
        //private boolean[] marked;
        private int bfs_island(Bag[] b, int index/*,int size*/,int island_num) 
        {
            int ct=1;
            //System.out.println(b[7].value+"  hahaha hahaha hahaha hahaha    "+index+"   "+island_num+"  ");
            Queue q = new Queue();
            //Graph g = new Graph(V, array);
            //marked[s] = true;
            q.addq(index);
            b[index].mark = island_num;
            //System.out.println(b[index].mark+"  ??         ");
            while (!q.isEmpty()) 
            {
                int v = q.deteleq(),i,ofindex;// v is an index
                //System.out.println(b[v].value+"  hahaha    "+v+"   "+island_num+"  "+b[v].size());
                //System.out.println();
                //ind = b[0].getindex(0);
                //ind = b[0].getindex(0);

                for (i=0;i<b[v].size();i++)
                {
                    //System.out.println(i);
                    ofindex = b[v].getindex(i);
                    //System.out.println(  b[ofindex].value   +"  "+b[ofindex].mark); 
                    if (b[ofindex].mark == 0) 
                    {
                        ct++;
                        q.addq(ofindex);
                        b[ofindex].mark = island_num;
                        //System.out.println("fjdfkdfjdkf");

                    }
                    //System.out.println(b[v].get(i)+"         "+b[i].mark+"               "+v+"   "+island_num+"  "+b[v].size());
                }
            }
            //System.out.println(b[v].get(i)+"         "+b[b[v].get(i)].mark+"               "+v+"   "+island_num+"  "+b[v].size());
            return ct;
        }
        private int bfs_path(Bag[] b, int index1,/*int index2,*/int island_num) 
        {
            int ct=1;
            Queue q = new Queue();
            q.addq(index1);
            b[index1].mark = 1230;
            while (!q.isEmpty()) 
            {
                int v = q.deteleq();
                int i,ofindex;// v is an index
                for (i=0;i<b[v].size();i++)
                {
                    ofindex = b[v].getindex(i);
                    if (b[ofindex].mark == island_num) 
                    {
                        /*if(ofindex == index2)
                        {
                            return ct;
                        }*/
                        q.addq(ofindex);
                        b[ofindex].mark = 1230;
                    }
                }
                ct++;
            }
            return ct;
        }
        public class Queue
        {
            int key,rear=-1,front=-1;
            ArrayList<Integer> queue = new ArrayList<Integer>(); 
            boolean isEmpty()
            {
                return (front == rear); 
            }
            void addq(int list)
            {
                queue.add(list);
                rear++;
            }
            int deteleq()
            {
                return queue.get(++front) ;
            }
        }
    }

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

