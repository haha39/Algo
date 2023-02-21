public class HW08_4108056041_4 extends  Buy_Phone_v2
{
    public static void main(String[] args) 
    {
        int a[][]  = { {8,7,7,4,2,1},{7,5,6,9,8,9},{5,2,4,3,7,3},{4,0,5,1,3,2},{2,4,4,6,2,1}};
        //int b[][]  = { {1,1},{2,4},{2,10},{4,11},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1},{4,11},{10,100}};
        //int c[][]  = { {1,1},{2,4},{2,10},{4,11},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1},{4,11},{100,100}};
        HW08_4108056041_4 test = new HW08_4108056041_4();
        int ans[][] = test.bestPhone(a);
        System.out.println();
        /*for(int i=0;i<ans.length;i++)
            System.out.println(ans[i][0]+"  "+ans[i][1]+"  "+ans[i][2]+"  "+ans[i][3]+"  "+ans[i][4]+"  "+ans[i][5]);*/
    }
	public int[][] bestPhone(int[][] inputArr)
    {
        int[][] ans;
        //int[] max = new int[6];
        int i,j,len = inputArr.length,num=0;
        int ans_index[] = new int[len];        
        for(i=0;i<len;i++)
        {
            System.out.println(inputArr[i][0]+"  "+inputArr[i][1]+"  "+inputArr[i][2]+"  "+inputArr[i][3]+"  "+inputArr[i][4]+"  "+inputArr[i][5]);
        }
        QuickSort(inputArr, 0, len-1);
        for(i=0;i<len;i++)
            System.out.println(inputArr[i][0]+"  "+inputArr[i][1]+"  "+inputArr[i][2]+"  "+inputArr[i][3]+"  "+inputArr[i][4]+"  "+inputArr[i][5]);
        //找出尾巴的那個
        int tmp=0,yes,ct1,ct2,ct3;
        if(inputArr[len-1][0] > inputArr[len-2][0])
        {
            ans_index[num++] = len-1;
            /*for(i=0;i<6;i++)
                max[i] = inputArr[len-1][i];*/
            tmp = 1;
        }
        else//equal
        {
            ct3=0;yes=0;
            while(inputArr[len-1-ct3][0] == inputArr[len-2-ct3][0])
            {
                for(i=0;i<5;i++)
                {
                    ct1=0;ct2=0;
                    while(inputArr[len-1-ct3][0] == inputArr[len-2-ct3-ct2][0])
                    {
                        if(inputArr[len-1-ct3][i] > inputArr[len-2-ct3-ct2][i])
                            ct1++;
                        ct2++; 
                    }
                    if(ct1 == ct2)//找到最大的
                    {
                        ans_index[num++] = len-1-ct3;
                        /*for(i=0;i<6;i++)
                            max[i] = inputArr[len-1-ct3][i];*/
                        yes = 1;
                        tmp = ct3+2;
                        break;
                    }
                    if(yes == 1)
                        break;
                }
                ct3++;
            }
            if(num == 0)
            {
                //012 3 4       5 5-1-1 
                tmp = 2+ct3;
                ans_index[num++] = len-1-ct3;
                /*for(i=0;i<6;i++)
                    max[i] = inputArr[len-1-ct3][i];*/
            }
        }
        yes=0;ct1=0;ct2=0;ct3=0;
        for(i=len-1-tmp;i>=0;i--)/////////////////////////////////////////////////////////
        {
            if(inputArr[i][0]>inputArr[ans_index[num-1]][0])
            {
                for(j=1;j<6;j++)
                {
                    if(inputArr[i][j]>inputArr[ans_index[num-1]][j])
                    {
                        //max[j] = inputArr[i][j];
                        yes=1;
                    }
                }
                if(yes == 1)
                {
                    ans_index[num++] = i;
                    //max[0] = inputArr[i][0];
                }
                yes = 0;
            }
            else//equal
            {
                if(inputArr[ans_index[num-1]][0] == inputArr[i][0])
                {
                    for(j=1;j<6;j++)
                    {
                        if(inputArr[i][j]>=inputArr[ans_index[num-1]][j]) 
                        {
                            //max[j] = inputArr[i][j];
                            yes=1;
                            ct1++;
                        }
                    }
                    if(yes == 1)
                    {
                        if(ct1==5)
                        {
                            num--;
                            ans_index[num++] = i;
                        }
                        else
                        {
                            ans_index[num++] = i;
                        }
                    }                    
                }
                else
                {
                    for(j=1;j<6;j++)
                    {
                        if(inputArr[i][j]>=inputArr[ans_index[num-1]][j]) 
                        {
                            //max[j] = inputArr[i][j];
                            yes=1;
                            ct1++;
                        }
                    }
                    if(yes == 1)
                    {
                        ans_index[num++] = i;
                        //max[0] = inputArr[i][0];
                    }  
                }
                yes = 0;
            }
        }
        ans = new int[num][6];
        for(i=num-1;i>=0;i--)
        {
            ans[num-i-1][0] = inputArr[ans_index[i]][0];
            ans[num-i-1][1] = inputArr[ans_index[i]][1];
            ans[num-i-1][2] = inputArr[ans_index[i]][2];
            ans[num-i-1][3] = inputArr[ans_index[i]][3];
            ans[num-i-1][4] = inputArr[ans_index[i]][4];
            ans[num-i-1][5] = inputArr[ans_index[i]][5];
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
