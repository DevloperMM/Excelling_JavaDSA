package $8_Recursion;

public class $2_first_occur_in_array {
    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (key == arr[i]) {
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,4,8,2,3,5,8};
        System.out.println(firstOccurence(arr1, 8, 0));
    }
}
