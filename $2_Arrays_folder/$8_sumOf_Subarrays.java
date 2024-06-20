package $2_Arrays_folder;

public class $8_sumOf_Subarrays {

    public static void sumOfsubArr(int arr[]) {
        int n = arr.length;
        int min_sum = Integer.MAX_VALUE;
        int max_sum = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int curr_sum = 0;
                for (int k=i; k<=j; k++) {
                    curr_sum += arr[k];
                }
                System.out.print(curr_sum + "  ");
                if (curr_sum > max_sum) {
                    max_sum = curr_sum;
                }
                if (curr_sum < min_sum) {
                    min_sum = curr_sum;
                }
            }
            System.out.println();
        }
        System.out.println("The largest sum is " + max_sum);
        System.out.println("The smallest sum is " + min_sum);
    }

    public static void main(String[] args) {
        int numbers[] = {-1,1,3,5,7};
        sumOfsubArr(numbers);
    }
}
