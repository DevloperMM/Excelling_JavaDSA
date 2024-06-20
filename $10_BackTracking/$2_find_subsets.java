package $10_BackTracking;

public class $2_find_subsets {
    public static void subsets(String str, String ans, int i) {
        //base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        //recursion
        //Yes choice
        subsets(str, ans+str.charAt(i), i+1);
        //No choice
        subsets(str, ans, i+1);
    }

    public static void main(String[] args) {
        subsets("ABC", "", 0);

        //Assignment
        //1. Do this question using StringBuilder
        //2. Print the number of subsets that printed
    }
}
