package $8_Recursion;

public class $3_last_occur_in_array {
    public static int lastOccurence(int arr[], int key, int i) {
        //base case
        if (i==arr.length) {
            return -1;
        }

        //check forward for the key
        int isFound = lastOccurence(arr, key, i+1);

        //check with itself now
        if (isFound != -1 && arr[i] == key) {
            return i;
        }
        
        return isFound;
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,4,8,2,3,5,8};
        System.out.println(lastOccurence(arr1, 8, 0));
    }
}