package $2_Arrays_folder;

public class $4_binary_search {
    public static int binSearch(int arr[], int key) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid]==key) {
                return mid+1;
            } else if (arr[mid]<key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            } 
        }
        return -1;
    }
    public static void main(String[] args) {
        int marks[] = {2,5,8,10,23,37,89,100};
        int key = 37;
        
        System.out.println("KEY foundt at "+binSearch(marks, key)+" position");
    }
}
