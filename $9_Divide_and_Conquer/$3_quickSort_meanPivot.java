package $9_Divide_and_Conquer;

public class $3_quickSort_meanPivot {
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // Do the quick Sort by taking mean or median as pivot.

    public static void main(String[] args) {
        int arr[] = {3,34,1,5,7,45,7};
        //quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
