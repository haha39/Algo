public class HW07_4108056041_3 extends Buy_Phone
{
    public  int[][] bestPhone(int[][] inputArr)
    {
        int ans[][],i,j=0,k,ans_index[] ,h,tmp_index=0;
        ans_index = new int[inputArr.length];
        ans_index[0]  = inputArr.length-1;
        QuickSort(inputArr, 0, inputArr.length-1);
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
