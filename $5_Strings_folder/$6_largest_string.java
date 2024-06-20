package $5_Strings_folder;

public class $6_largest_string {
    public static void main(String[] args) {
        String str[] = {"ahemdabad","a@bcd","AHEMDABAD"};
        String fruits[] = {"apple","mango","banana"};

        //ASCII Code
        System.out.println((int)'h');
        System.out.println((int)'@');

        //function test
        System.out.println((str[0]).compareTo(str[1]));
        System.out.println((str[0]).compareToIgnoreCase(str[2]));

        //function to printing largest string --> O(x*n) where x is length of largest string and n is the length of array.
        String largest = fruits[0];
        for (int i=0; i<fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}
