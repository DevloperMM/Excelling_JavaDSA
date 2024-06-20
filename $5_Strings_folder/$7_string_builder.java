package $5_Strings_folder;

public class $7_string_builder {
    public static String changeCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for (char ch='a'; ch<='z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
        System.out.println(sb.length());

        //convert to uppercase (more specifically, sentence case)
        String str = "hey there, mangal murti this side";
        System.out.println(changeCase(str));
    }
}
