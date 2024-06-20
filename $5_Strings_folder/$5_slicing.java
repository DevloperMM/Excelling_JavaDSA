package $5_Strings_folder;

public class $5_slicing {
    public static String slice(String str, int si, int ei) {
        String substr = "";
        for (int i=si; i<ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String str = "HelloWorld";
        // System.out.println(slice(str, 0, 5));
        System.out.println(str.substring(0, 5));
    }
}