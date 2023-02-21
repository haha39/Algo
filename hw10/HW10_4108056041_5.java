public class HW10_4108056041_5 extends SortingArray//quick sort
{
    public static void main(String[] args) 
    {
        int a[]  = {-1,2,5,9,8,7,1,3,2};
        HW10_4108056041_1 test = new HW10_4108056041_1();
        int ans[] = test.sorting(a);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    } 
	public  int[] sorting(int[] A)
    {
        
        //QuickSort(A, 0, A.length-1);
        return A;
    }
   
}
// cutoff 改良  <+sort  shell