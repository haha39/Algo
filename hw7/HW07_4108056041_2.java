public class HW07_4108056041_2 extends Buy_Phone
{
    public static void main(String[] args)
    {
        int a[][]  = { {1,1},{2,4},{2,10},{4,11},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1},{4,11}};
        HW07_4108056041_2 test = new HW07_4108056041_2();
        int ans[][] = test.bestPhone(a);
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i][0]+"  "+ans[i][1]);
    }        
    public  int[][] bestPhone(int[][] inputArr)
    {
        int ans[][],i,j=0,k,ans_index[],h,tmp_index=0;
        ans_index = new int[inputArr.length];
        QuickSort(inputArr, 0, inputArr.length-1);
        /*for(i=0;i<inputArr.length;i++)
            System.out.println(inputArr[i][0]+"  "+inputArr[i][1]);*/
        for(i=0;i<inputArr.length-1;i++)
        {
            if(inputArr[i+1][0]>inputArr[i][0])
            {
                for(h=i;h<inputArr.length-1;h++)
                {
                    if(inputArr[h+1][1]>=inputArr[i][1])
                    {
                        break;
                    }                        
                    if(h==inputArr.length-2)
                    {
                        ans_index[j]=i;
                        j++;
                    }
                }
            }
            else
            {
                k=i;
                while(inputArr[k][0] == inputArr[k+1][0])
                {
                    if(inputArr[k+1][1]<inputArr[k][1])
                        tmp_index = k;
                    else
                        tmp_index = k+1;  
                    k++;
                    if(k==inputArr.length-1)
                        break;
                }
                for(h=k;h<inputArr.length-1;h++)
                {
                    if(inputArr[h+1][1]>=inputArr[tmp_index][1] )
                    {
                        break;
                    }
                    if(h==inputArr.length-2)
                    {
                        ans_index[j]=tmp_index;
                        j++;
                    }
                }
                    i=k;
            }
        }
        ans = new int[j][2];
        for(i=0;i<j;i++)
        {
            ans[i][0] = inputArr[ans_index[i]][0];
            ans[i][1] = inputArr[ans_index[i]][1];
        }
        //System.out.println(j);
        return ans;
    }
    public void QuickSort(int[][] arr,int left,int right)
    {
        if (right <= left)
        return;
        int pivotindex = (left + right)/2,i;
        int pivot = arr[pivotindex][0];
        Swap(arr,pivotindex,right);
        int swapindex = left;
        for (i = left; i < right;i++)
        {
            if (arr[i][0] <= pivot)
            {
                Swap(arr, i, swapindex);
                ++swapindex;
            }
        }
        Swap(arr, swapindex, right);
        QuickSort(arr, left, swapindex - 1);
        QuickSort(arr, swapindex + 1, right);
    }
    public void Swap(int[][] arr, int x, int y)
    {
        int[] temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}


/*
public static void shuffle(double[] a) 
{
    int N = a.length;
    for (int i = 0; i < N; i++)
        { // Exchange a[i] with random element in a[i..N-1]
        int r = i + StdRandom.uniform(N-i);
        double temp = a[i];
        a[i] = a[r];
        a[r] = temp;





        System.out.println(arr[1][0]+" "+arr[1][1]+" "+arr[2][0]+" "+arr[2][1]);
    } 
}
*/