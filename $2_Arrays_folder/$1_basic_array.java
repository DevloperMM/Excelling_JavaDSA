package $2_Arrays_folder;

public class $1_basic_array{
    public static void update(int marks[], int nonChange) {
        nonChange = 10;
        for (int i=0; i<marks.length; i++) {
            marks[i] += 1;
        }
    }
    public static void main(String[] args) {
        int marks[] = {98,45,78,98};
        int nonChange = 5;
        update(marks, nonChange);
        System.out.println(nonChange);

        //print marks
        for (int i=0; i<marks.length; i++) {
            System.out.println(marks[i]);
        }
    }
}