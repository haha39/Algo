public class HW06_4108056041_4 extends Dessert_Desert
{
    public int[] maxBlocks(int[][] inputArr)
    {
        int i,ct,j,k,h;
        int ans[];
        ans = new int[inputArr.length];
        int[] max;
        int maximum = inputArr[0].length;
        for(i=1;i<inputArr.length;i++)
        {
            if(maximum < inputArr[i].length)
                maximum = inputArr[i].length;
        }
        max = new int[maximum];
        for(i=0;i<inputArr.length;i++)
        {
            ct=0;k=0;
            max[k]=inputArr[i][0];
            ct++;
            for(j=1;j<inputArr[i].length;j++)
            {
                if(inputArr[i][j]>=max[k])
                {
                    ct++;
                    k++;
                    max[k]=inputArr[i][j];
                }
                else
                {
                    for(h=1;h<=k;h++)
                    {                
                        if(inputArr[i][j]<max[k-h])
                        {
                            ct--;
                        }
                        else
                            break;
                    }
                    max[ct-1]=max[k];
                    k=ct-1;
                }                 
            }    
            ans[i]=ct;
        }
        return ans;
    }    
}