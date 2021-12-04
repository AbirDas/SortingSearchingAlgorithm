package sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] {4,8,9,3,6,1,10,5,2};
		mergeSort(arr,0,arr.length-1);
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}
	
	public static void merge(int[] arr,int l,int mid,int r) {
		int[] temp = new int[arr.length];
		
		int i=l;
		int j=mid+1;
		int k=l;
		
		while(i<=mid && j<=r) {
			if(arr[i]>arr[j]) {
				temp[k] = arr[j];
				j++;
			}else {
				temp[k] = arr[i];
				i++;
			}
			k++;
		}
		
		while(i<=mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		
		while(j<=r) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		
		for(int m=l; m<=r; m++) {
			arr[m] = temp[m];
		}
	}

}
