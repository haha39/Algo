public class HW03_4108056041_1 extends HillFinding
{
    public static void main(String[] args) 
    {
        int[] a = {4,4,5,7,8,8,0,1,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};//19
        int[] b = {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,7,8,8,0,1,3,4,4,4};//28 24
        int[] c = {5,6,7,1,2,4};
        int[] d = {5,6,7,1,2,4,4};
        int[] e = {5,7,8,8,1,2,4};
        int[] f = {4,4,4,4,4,4,5,7,8,8,0,1,3};//16 
        int[] g = {5,7,8,8,0,1,3,4,4,4};//28 24
        int[] h = {4,4,5,7,8,8,0,1,3,4,4,4,4};//28 24

        HW03_4108056041_1 test = new HW03_4108056041_1();
//        System.out.println(b.length);
        System.out.println(test.H_Finding(a));
        System.out.println(test.H_Finding(b));
        System.out.println(test.H_Finding(c));
        System.out.println(test.H_Finding(d));
        System.out.println(test.H_Finding(e));
        System.out.println(test.H_Finding(f));
        System.out.println(test.H_Finding(g));
        System.out.println(test.H_Finding(h));
    }
    public int H_Finding(int[] A)
    {
        int med=A.length/2,ans=0,left=0,right=A.length-1/*ct=0*/;
//        System.out.println(med+"    "+left+"    "+right+"    "+A[left]+"    "+A[right]+"    "+A[med]);
        while( A[left]==A[right] )
        {
//        System.out.println(med+" ddddddddd   "+right+"    "+left);

            left++;
            right--;
//            ct++;
        }        
//        System.out.println(med+"    "+right+"    "+left);

        while(ans==0)
        {
//            System.out.println(med+"    "+right);
//            System.out.println(med+"    "+left+"    "+right+"    "+A[left]+"    "+A[right]+"    "+A[med]);
            if(A[med]>A[left] || A[med]>A[right])
            {
                if(A[med+1]-A[med]<0)
                {
                    ans = A.length-med-2;
                }
                else
                {
                    med = (right+med)/2;
                }
            }
            else 
            {
                if(A[med]-A[med-1]<0)
                {
                    ans = A.length-med-1;
                }
                else
                {
                    right = med;
                    med = med/2;
                }
            }
        }
        return ans;
    }
}
