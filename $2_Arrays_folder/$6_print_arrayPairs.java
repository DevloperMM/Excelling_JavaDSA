package $2_Arrays_folder;

public class $6_print_arrayPairs {
    public static void printPairs(int num[]) {
        int total_pair = 0;
        for (int i=0; i<num.length; i++) {
            int one = num[i];
            for (int j=i+1; j<num.length; j++) {
                System.out.print("("+one+", "+num[j]+")");
                total_pair++;
            }
            System.out.println();
        }
        System.out.println("Total pairs are : " + total_pair);
    }
    public static void main(String[] args) {
        int numbers[] = {2,5,6,8,15,34,45};
        printPairs(numbers);
    }
}
