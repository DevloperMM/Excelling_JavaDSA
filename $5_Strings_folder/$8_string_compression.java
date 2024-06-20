package $5_Strings_folder;

public class $8_string_compression {
    public static String compressByString(String str) {
        String newstr = "";
        for (int i=0; i<str.length(); i++) {
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if (count != 1) {
                newstr += count.toString();
            }
        }
        return newstr;
    }
    public static String compressByStringBuilder(String str) {
        StringBuilder newstr = new StringBuilder("");
        for (int i=0; i<str.length(); i++) {
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if (count != 1) {
                newstr.append(count.toString());
            }
        }
        return newstr.toString();
    }
    public static void main(String[] args) {
        String str = "aaabbbccddee";
        //System.out.println(compressByString(str));
        System.out.println(compressByStringBuilder(str));
    }
}
