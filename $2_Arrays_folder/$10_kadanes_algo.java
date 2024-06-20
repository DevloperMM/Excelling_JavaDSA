package $2_Arrays_folder;

public class $10_kadanes_algo {
    public static void kadane_sum (int arr[]) {
        // checking the sign of all numbers
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]<0) {
                count++;
            }
        }

        // if all the numbers of the array are negative
        if (count == arr.length) {
            int ms = Integer.MIN_VALUE;
            for (int i=0; i<arr.length; i++) {
                ms = Math.max(ms, arr[i]);
            }
            System.out.println("The maximum sum of subarray is " + ms);
        }
        
        // rest all the comibinations
        else {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            cs += arr[i];
            if (cs < 0) {
                cs = 0;
            }
            // System.out.print(cs + "  ");
            ms = Math.max(cs, ms);
        }
        System.out.println();
        System.out.println("The maximum sum of subarray is " + ms);
        }
    }
    public static void main(String[] args) {
        int numbers[] = {-4,-3,-2,-1};
        kadane_sum(numbers);
    }
}
