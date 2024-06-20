package $1_Basic_Java.Practice_Questions;

public class $7_patterns {
    public static void main(String[] args) {
        // Pattern - 01
        {
            int n=5;
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        System.out.println();
        
        // Pattern - 02
        {
            int n=6;
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= i; j++){
                    System.out.print(j);
                }
                System.out.println();
            }
        }
        System.out.println();

        // Pattern - 03
        {
            int n=6;
            // for (int i = 1; i <= n; i++){
            //     for (int j = 1; j <= (n-i+1); j++){
            //         System.out.print("*");
            //     }
            //     System.out.println();
            // }

            for (int i = 1; i <= n; i++){
                for (int j = n+1-i; j >= 1; j--){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        System.out.println();

        // Pattern - 04
        {
            int n=5;
            char ch = 'A';
            for (int line = 1; line <= n; line++) {
                for (int chars = 1; chars <= line; chars++) {
                    System.out.print(ch);
                    ch++;
                }
                System.out.println();
            }
        }
    }
}
