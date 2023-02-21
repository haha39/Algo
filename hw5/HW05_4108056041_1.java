public class HW05_4108056041_1 extends LLK
{
    public static void main(String[] args) 
    {
        int a[][]  = {{1,1},{2,42},{4,4},{5,5} };
        HW05_4108056041_1 test = new HW05_4108056041_1();
        boolean ans = test.checkLLK(a);
        System.out.println(ans);
    }
	public boolean checkLLK(int[][] array)
    {
        //boolean ans=false;
        int num=array.length,i,j,k,ctx=0,cty=0;
        //int num2 = ((num+1)*num)/2;
        double Slope[][]= new double[num-2][num];
        //System.out.println(num);
        for(i=0;i<num-2;i++)
        {
            for(j=1;(i+j)<num;j++)
            {
                //System.out.println(i+"  "+j+"  "+(i+j));
                if(array[i+j][0]-array[i][0]==0)
                {
                    ctx++;
                }                
                else if(array[i+j][1]-array[i][1]==0)
                {
                    cty++;
                }
                else 
                {
                    Slope[i][i+j]=((double)(array[i+j][1]-array[i][1])) / ((double)(array[i+j][0]-array[i][0]));
                }
                if(ctx==2 || cty==2)
                    return true;
            }
            ctx=0;cty=0;
        }
        int ct=0;
        for(i=0;i<num-2;i++)
        {
            for(j=i+1;j<num;j++)
            {
                for(k=1;(j+k)<num;k++)
                {
                    //System.out.println(Slope[i][j]+"  "+Slope[i][j+k]+"  "+i+j+k);
                    if(Slope[i][j]==Slope[i][j+k])
                        return true;
                    //System.out.println(Slope[i][j]+"  "+Slope[i][j+k]+"  "+i+j+k+ct);
                }
            }
            ct=0;
        }
        return false;
    }
}
