package sort;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = new int[] {4,8,9,3,6,1,10,5,2};
		//mergeSort(arr,0,arr.length-1);
		int[] ans = ms.mergeSort_new(arr,0,arr.length-1);
		for(int a : ans) {
			System.out.print(a+" ");
		}
	}
	
	//new
	private int[] mergeSort_new(int[] nums, int start, int end) {
        if(end-start==0) {
            return new int[]{nums[start]};
        }
        int mid = (start+end) / 2;
        int[] left=mergeSort_new(nums,start,mid);
        int[] right=mergeSort_new(nums,mid+1,end);
        return merge(left,right);
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] temp = new int[left.length+right.length];
        
        int idxLeft=0;
        int idxRight=0;
        int idx=0;
        
        while(idxLeft<left.length && idxRight<right.length) {
            if(left[idxLeft] > right[idxRight]) {
                temp[idx] = right[idxRight];
                idxRight++;
            } else {
                temp[idx] = left[idxLeft];
                idxLeft++;
            }
            idx++;
        }
        
        while(idxLeft<left.length) {
            temp[idx] = left[idxLeft];
            idxLeft++;
            idx++;
        }
        
        while(idxRight<right.length) {
            temp[idx] = right[idxRight];
            idxRight++;
            idx++;
        }
        
        return  temp;
    }
	
	
	
	//old
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
