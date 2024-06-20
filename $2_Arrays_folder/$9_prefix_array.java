package $2_Arrays_folder;

public class $9_prefix_array {
    public static void prefix_sum(int arr[]) {

        // Made a prefix array (and print if i wish)
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        System.out.print(arr[0] + "  ");
        for (int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
            System.out.print(prefix[i] + "  ");
        }
        System.out.println();
        System.out.println();

        // Now calculate subarray sum using prefix array formula
        int max_sum = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                int curr_sum = 0;
                curr_sum += (i==0) ? prefix[j] : prefix[j] - prefix[i-1];
                System.out.print(curr_sum + "  ");
                if (curr_sum > max_sum) {
                    max_sum = curr_sum;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("The max sum of subArray exist is " + max_sum);
    }
    public static void main(String[] args) {
        int numbers[] = {-1,1,3,5,7};
        prefix_sum(numbers);

    }
}
