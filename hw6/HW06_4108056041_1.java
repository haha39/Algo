public class HW06_4108056041_1 extends Dessert_Desert
{
    public static void main(String[] args) 
    {
        int a[][]  = { {1,1,1,1,1,1,1},{1,3,5,7,9},{1,2,3},{5,4,3,2,1},{2,1,3,2},{2,1,0,1,3,7,4,9,9,3,2},{0,2,3,0,5,0,0,0,1,2,0} };
        HW06_4108056041_1 test = new HW06_4108056041_1();
        int ans[] = test.maxBlocks(a);
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i]);
    }
    public int[] maxBlocks(int[][] inputArr)
    {
        int i,ct,j,k,h;
        int ans[];
        ans = new int[inputArr.length];
        for(i=0;i<inputArr.length;i++)
        {
            //System.out.println(i);
            ct=0;k=0;
            int max[];
            max = new int[inputArr[i].length];
            max[k]=inputArr[i][0];
            ct++;
            for(j=1;j<inputArr[i].length;j++)//start form 111111111111111111111111111111111
            {
                //System.out.println("i : "+i+ "  j : "+j+"  k : "+k+"  ct : "+ct+" "+inputArr[i][j]);
                if(inputArr[i][j]>=max[k])
                {
                    ct++;
                    k++;
                    max[k]=inputArr[i][j];
                }
                else /*if(inputArr[i][j]<max[k] && inputArr[i][j-1]==max[k])*/
                {
                    for(h=1;h<=k;h++)
                    {                
                        //System.out.println("j : "+j+"  "+"k : "+k+"   "+"h : "+h+"  "+"ct : "+ct);
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
