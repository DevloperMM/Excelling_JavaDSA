package $1_Basic_Java.Practice_Questions;

public class $11_advanced_patterns {
    public static void rotated_pyramid(int n) {
        // METHOD --> 1
        // for (int i=1; i<=n; i++) {
        //     for (int j=1; j<=n; j++) {
        //         if (i+j>n) {
        //             System.out.print("* ");
        //         } else {
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        // METHOD --> 2
        for (int i=1; i<=n; i++) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //stars
            for (int k=1; k<=i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void num_half_pyramid(int n) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n-i+1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void hollowRec(int Rows, int Cols) {
        for (int i=1; i<=Rows; i++) {
            for (int j=1; j<=Cols; j++) {
                if (i==1 || i==Rows || j==1 || j==Cols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void floyd_pattern(int n) {
        int c=1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(c+" ");
                c++;
            }
            System.out.println();
        }
    }
    public static void bin_01(int n) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                if ((i+j)%2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void butterfly(int n) {
        for (int i=1; i<=n; i++) {
            //stars
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            //spaces
            for (int k=1; k<=2*(n-i); k++) {
                System.out.print("  ");
            }
            //stars
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=n; i>=1; i--) {
            //stars
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            //spaces
            for (int k=1; k<=2*(n-i); k++) {
                System.out.print("  ");
            }
            //stars
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void solid_rhombus(int n) {
        for (int i=1; i<=n; i++) {
            //space
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //star
            for (int k=1; k<=n; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void hollow_rhombus(int n) {
        for (int i=1; i<=n; i++) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            //hollow rectangle
            for (int j=1; j<=n; j++) {
                if (i==1 || i==n || j==1 || j==n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void diamond(int n) {
        for (int i=1; i<=n; i++) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int k=1; k<=2*i-1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=n; i>=1; i--) {
            //spaces
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int k=1; k<=2*i-1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // rotated_pyramid(5);
        // num_half_pyramid(7);
        // hollowRec(5,6);
        // floyd_pattern(6);
        // bin_01(6);
        // butterfly(6);
        // solid_rhombus(5);
        // hollow_rhombus(5);
        diamond(5);
    }
}
