package $2_Arrays_folder;

public class $7_print_subarrays {
    public static void subArr(int arr[]) {
        int total_subarr = 0;

        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                for (int k=i; k<=j; k++) {
                    System.out.print(arr[k]+" ");
                }
                // System.out.println();
                System.out.print("| ");
                total_subarr++;
            }
            System.out.println();
        }
        System.out.println("Total subarrays are : " + total_subarr);
    }
    public static void main(String[] args) {
        int numbers[] = {1,3,5,6,8};
        subArr(numbers);
    }
}
