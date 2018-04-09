

public class QuickSort {

  private static int partition(int[] arr, int left, int right) {

    int i = left, j = right;
    int temp;
    int pivotValue = arr[(left + right) / 2];

    while (i <= j) {
      while (arr[i] < pivotValue) {
        i++;
      }
      while (arr[j] > pivotValue) {
        j--;
      }
      if (i <= j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
    return i;

  }

  private static void quickSort(int[] arr, int left, int right) {
    // has to be left + right cause these values change recursively
    int partitionIndex = partition(arr, left, right);
    if (left < partitionIndex - 1) {
      quickSort(arr, left, partitionIndex - 1);
    }
    if (partitionIndex < right) {
      quickSort(arr, partitionIndex, right);
    }
  }

  public static void main(String [] args) {
    int[] arr1 = {2, 4, 1, 6, 3, 0, 10, 2};
    int[] arr2 = {10, 80, 30, 90, 40, 50, 70};
    int[] arr3 = {1, 12, 3, 10, 5, 11, 7};

    int[] arr = arr1;

    quickSort(arr, 0, arr.length-1);

    for(int number : arr) {
      System.out.print(number + " ");
    }
    System.out.println("");
  }
}
