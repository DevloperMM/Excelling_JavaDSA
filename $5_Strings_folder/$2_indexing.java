package $5_Strings_folder;

public class $2_indexing {
    public static void printLetters(String str) {
        for (int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }
    public static void main(String[] args) {
        String str = "Hello World";
        // System.out.println(str.charAt(6));
        printLetters(str);
    }
}
