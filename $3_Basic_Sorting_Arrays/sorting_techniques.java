package $3_Basic_Sorting_Arrays;

public class sorting_techniques {

    public static void print_arr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int turn=0; turn<n-1; turn++) {
            boolean swap = false;
            for (int j=0; j<n-1-turn; j++) {
                if (arr[j]>arr[j+1]) { // (arr[j] > arr[j+1]) : for descending
                    //swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            // optimization for best case
            if (swap == false) {
                break;
            }
        }
    }
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            int minPos = i;
            for (int j=i+1; j<n; j++) {
                if (arr[minPos]>arr[j]) { // arr[minPos] > arr[j] --> for descending
                    minPos = j;
                    //minPos is actually the position of minimum
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > temp) { //(arr[j] < temp) : for descending
                arr[j+1] = arr[j];
                j--;
            }

            // insertion
            arr[j+1] = temp;
        }
    }
    public static void countingSort(int arr[]) {
        int n = arr.length;

        // find largest number in array
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // made an array of size 0 to largest
        int count[] = new int[largest+1];
        for (int i=0; i<n; i++) {
            int temp = arr[i];
            count[temp]++;
        }

        // sorting
        int j=0;
        for (int i=0; i<n; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {5,4,10,1,3,2,7};
        print_arr(arr1);
        // bubbleSort(arr1);
        // selectionSort(arr1);
        insertionSort(arr1);
        print_arr(arr1);
        System.out.println();

        // int arr2[] = {1,2,4,4,1,5,7,8,4};
        // countingSort(arr2);
        // print_arr(arr2);
    }
}