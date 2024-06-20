package $6_Bit_Manipulation;

public class $3_bit_operations {
    public static int getbit(int n, int i) {
        int bitmask = 1<<i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    public static int setbit(int n, int i) {
        int bitmask = 1<<i;
        return n|bitmask;
    }
    public static int clearbit(int n, int i) {
        int bitmask = 1<<i;
        return n & ~bitmask;
    }
    public static int updatebit(int n, int i, int newbit) {
        // if (newbit == 0) {
        //     return clearbit(n, i);
        // } else {
        //     return setbit(n, i);
        // }

        n = clearbit(n, i);
        int bitmask = newbit<<i;
        return n|bitmask;
    }
    public static int clearIbits(int n, int i) {
        int bitmask = (~0)<<i;
        return n & bitmask;
    }
    public static int clearRangeBits(int n, int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
    }
    public static void main(String[] args) {
        
        // System.out.println(getbit(10, 3));
        // System.out.println(setbit(10, 2));
        // System.out.println(clearbit(10, 1));
        // System.out.println(updatebit(10, 2, 1));
        // System.out.println(clearIbits(15, 2));
        System.out.println(clearRangeBits(255, 2, 5));
    }
}
