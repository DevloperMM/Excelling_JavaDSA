package $13_Stacks;

import java.util.Stack;

public class $8_max_area_histogram {
    public static int maxHistArea(int arr[]) {
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right - O(n)
        Stack<Integer> s = new Stack<>();
        for (int i=arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Greater Left - O(n)
        s = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Current Area - O(n)
        int maxArea = 0;
        for (int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        System.out.print("Max area in histogram is = ");
        System.out.println(maxHistArea(arr));
    }
}
