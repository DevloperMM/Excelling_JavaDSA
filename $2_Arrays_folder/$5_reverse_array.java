package $2_Arrays_folder;

public class $5_reverse_array {
    public static void reverse(int num[]) {
        int first = 0;
        int last = num.length-1;
        while (first<last) {
            int temp = num[first];
            num[first] = num[last];
            num[last] = temp;

            first ++;
            last --;
        }
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,5,9,11,23};
        reverse(numbers);
        for (int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
}
