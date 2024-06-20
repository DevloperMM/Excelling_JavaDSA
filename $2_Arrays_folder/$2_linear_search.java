package $2_Arrays_folder;

public class $2_linear_search {
    public static int linSearch(int numbers[], int key) {
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i]==key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[] = {2,3,6,9,8,10,45,23,0};
        int key = 20;
        int index = linSearch(numbers, key);
        if (index==-1) {
            System.out.println("Not found");
        } else {
            System.out.println("KEY found at index = " + index);
        }
    }
}
