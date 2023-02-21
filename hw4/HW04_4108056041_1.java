public class HW04_4108056041_1 extends One_0k_rock
{
    public static void main(String[] args) 
    {
        String[] a = {"0011","00111"};//
        String[] b = {"0","1"};//
        String[] c = {"01","1100","1111"};
        HW04_4108056041_1 test = new HW04_4108056041_1();
        boolean[] ans = test.one0k(c);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }         
    }
	public  boolean[]  one0k(String[] str)
    {
        int len = str.length;
        boolean[] ans = new boolean[len];
        for(int i=0;i<len;i++)
        {
            ans[i] = true;
            int med = str[i].length()/2,j=0;
            if(str[i].length()%2==0 && str[i].charAt(med-1)=='0' && str[i].charAt(med)=='1')
            {
                while(j<med && ans[i]==true)
                {
                    if(str[i].charAt(j)!='0')
                    {
                        ans[i] = false;
                    }
                    j++;
                }
                    while(j<str[i].length() && ans[i]==true)
                    {
                        if(str[i].charAt(j)!='1')
                        {
                            ans[i] = false;
                        }
                        j++;
                    }
            }
            else
            {
                ans[i] = false;
            }
        }
        return ans;
    }
}
