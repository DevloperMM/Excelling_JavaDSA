package $2_Arrays_folder;

public class $11_trap_rainwater {
    public static int hold_water(int arr[]) {
        int n = arr.length;
        if (n<=2) {
            return 0;
        }

        // calculate left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }
        // calculate right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }
        int trapWater = 0;
        // loop
        for (int i=0; i<n; i++) {
            int waterLvl = Math.min(leftMax[i], rightMax[i]);
            trapWater += (waterLvl - arr[i]);
        }
        return trapWater;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(hold_water(height));
    }
}
