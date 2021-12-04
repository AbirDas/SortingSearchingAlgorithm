package search;


public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,4,6,7,8,9};
		System.out.println(binarySearch(arr,4,0,arr.length-1));
	}
	
	public static boolean binarySearch(int[] arr, int find, int l, int r) {
		if(l>r) return false;
		
		int mid = (l+r)/2;
		if(arr[mid]==find) {
			return true;
		}else if(arr[mid]< find) {
			return binarySearch(arr,find,mid+1,r);
		}else {
			return binarySearch(arr,find,l,mid-1);
		}
	}
}
