package sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 3, 7, 9, 1, 5, 2, 4 };
		quickSort(arr, 0, arr.length - 1);
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int pivot = partition(arr, l, r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}
	}

	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[l];
		int i = l;
		int j = r;

		while (i < j) {
			// find greater than pivot to swap
			while (i <= r && arr[i] <= pivot)
				i++;
			// find less that pivot to swap
			while (j >= l && arr[j] > pivot)
				j--;

			if (i < j)
				swap(arr, i, j);

		}
		// bring pivot to original position, where all the lest side are less that pivot
		// and right side is greater that pivot.
		swap(arr, j, l);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
