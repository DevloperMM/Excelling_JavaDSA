package $9_Divide_and_Conquer;

public class $2_quick_sort {

    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si>=ei) {
            return;
        }
        int pivot_idx = partition(arr, si, ei);
        quickSort(arr, si, pivot_idx-1);
        quickSort(arr, pivot_idx+1, ei);
    }
    
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;
        for (int j=si; j<=ei; j++) { //here (j<=ei) is also giving right index of the pivot.
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // return i;
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

        /* pivot is taken individually to ensure it doesn't return negative index
        but the improvisation is fitting well. */
    }

    public static void main(String args[]) {
        // int arr[] = {6,2,9,8,3,5};
        int arr[] = {81,70,97,38,63,21,85,68,76,9,57,36,55,79,74,85,16,61,77,49,24};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
