package $2_Arrays_folder;

public class $3_cornerValues {
    public static int[] getCorner(int num[]) {
        int arr[] = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int i=0; i<num.length; i++) {
            if (arr[0] < num[i]) {
                arr[0] = num[i];
            }
            if (arr[1] > num[i]) {
                arr[1] = num[i];
            }
        }
        return arr;
    }
    public static int getLargest(int num[]) {
        int large = Integer.MIN_VALUE;
        for (int i=0; i<num.length; i++) {
            if (large < num[i]){
                large = num[i];
            }
        }
        return large;
    }
    public static int getSmallest(int num[]) {
        int small = Integer.MAX_VALUE;
        for (int i=0; i<num.length; i++) {
            if (small > num[i]) {
                small = num[i];
            }
        }
        return small;
    }
    public static void main(String[] args) {
        int num[] = {2,5,6,1,76,34,45,90};
        System.out.println("Largest no is " + getCorner(num)[0]);
        System.out.println("Smallest no is " + getCorner(num)[1]);
        System.out.println();
        System.out.println("Largest no is " + getLargest(num));
        System.out.println("Largest no is " + getSmallest(num));

    }
}