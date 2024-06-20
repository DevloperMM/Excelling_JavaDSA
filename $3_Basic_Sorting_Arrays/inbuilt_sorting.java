package $3_Basic_Sorting_Arrays;

import java.util.Arrays;
import java.util.Collections;

public class inbuilt_sorting {

    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {3,34,1,5,7,45,7};
        printArr(arr);

        int asc_sort_arr[] = arr;
        Arrays.sort(asc_sort_arr);
        System.out.print("Ascending Order Array = ");
        printArr(asc_sort_arr);

        Integer[] dsc_sort = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(dsc_sort, Collections.reverseOrder());
        int[] dsc_sort_arr = Arrays.stream(dsc_sort).mapToInt(Integer::intValue).toArray();
        System.out.print("Descending Order Array = ");
        printArr(dsc_sort_arr);
    }
}
