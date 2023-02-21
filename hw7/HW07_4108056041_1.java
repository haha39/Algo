public class HW07_4108056041_1 extends Buy_Phone
{
    public static void main(String[] args)
    {
        int a[][]  = { {1,1},{2,4},{2,10},{4,11},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1},{4,11},{10,3}};
        //int b[][]  = { {1,1},{2,4},{2,10},{4,11},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1},{4,11},{10,100}};
        //int c[][]  = { {1,1},{2,4},{2,10},{4,11},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1},{4,11},{100,100}};
        HW07_4108056041_1 test = new HW07_4108056041_1();
        int ans[][] = test.bestPhone(a);
        /*for(int i=0;i<ans.length;i++)
            System.out.println(ans[i][0]+"  "+ans[i][1]);
        System.out.println();        
        int ans_b[][] = test.bestPhone(b);
        for(int i=0;i<ans_b.length;i++)
            System.out.println(ans_b[i][0]+"  "+ans_b[i][1]);
        System.out.println();        
        int ans_c[][] = test.bestPhone(c);
        for(int i=0;i<ans_c.length;i++)
            System.out.println(ans_c[i][0]+"  "+ans_c[i][1]);
        System.out.println();*/
    }        
    public  int[][] bestPhone(int[][] inputArr)
    {
        int ans[][],i,j=0,k,ans_index[] ,h,tmp_index=0;
        ans_index = new int[inputArr.length];
        ans_index[0]  = inputArr.length-1;
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
                tmp_index = k;
                while(inputArr[k][0] == inputArr[k+1][0])
                {
                    if(inputArr[k+1][1]>inputArr[tmp_index][1]) 
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
        //System.out.println(j+"   "+inputArr[inputArr.length-1][0]+"    "+inputArr[ans_index[j]][0]);
            if(inputArr[inputArr.length-1][0] == inputArr[inputArr.length-2][0])
                ans_index[j] = tmp_index;   
            else 
            {
                ans_index[j] = inputArr.length-1;
            }    
        j++;
        ans = new int[j][2];
        for(i=0;i<j;i++)
        {
            ans[i][0] = inputArr[ans_index[i]][0];
            ans[i][1] = inputArr[ans_index[i]][1];
        }
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
