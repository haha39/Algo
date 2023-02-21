public class HW10_4108056041_3 extends SortingArray//MERGE SORT
{
    /*public static void main(String[] args) 
    {
        int a[]  = {-1,2,5,9,8,7,1,3,2};
        HW10_4108056041_3 test = new HW10_4108056041_3();
        int ans[] = test.sorting(a);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    }*/
	public  int[] sorting(int[] A)
    {
        mergeSort(A);
        return A;
    }
    public static void mergeSort(int[] arr){
		if(null == arr || arr.length < 2) return ;
		int[] aux = new int[arr.length];
		for(int k =0; k < aux.length; k++) 
			aux[k] = arr[k];
		mergeSort(aux, arr, 0, arr.length - 1);
	}
	private static void merge(int[] src, int[] tgt, int bidx, int eidx, int m){
		int i = bidx;
		int j = m + 1;
		
		for( int k = bidx; k <= eidx; k++){
			if(i > m) tgt[k] = src[j++];
			else if(j > eidx) tgt[k] = src[i++];
			else if( src[i] > src[j]) tgt[k] = src[j++];
			else tgt[k] = src[i++];
		}
	}
	private static void mergeSort(int[] src, int[] tgt, int bIdx, int eIdx){
		if(eIdx <= bIdx) return;
		int m = bIdx + (eIdx - bIdx)/2;
		
		mergeSort(tgt, src, bIdx, m);
		mergeSort(tgt, src, m + 1, eIdx);
		merge(src, tgt, bIdx, eIdx, m);
	}
}
