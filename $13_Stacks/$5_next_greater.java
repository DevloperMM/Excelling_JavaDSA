package $13_Stacks;

import java.util.*;

public class $5_next_greater {
    //Brute Force Algorithm
    // public static void nxtGreater(int arr[], int result[]) {
    //     result[result.length-1] = -1;
    //     for (int i=0; i<arr.length-1; i++) {
    //         for (int j=i+1; j<arr.length; j++) {
    //             if (arr[j] > arr[i]) {
    //                 result[i] = arr[j];
    //                 break;
    //             } else {
    //                 result[i] = -1;
    //             }
    //         }
    //     }
    // }


    //Stack Implementation - Optimised
    public static void nxtGreater(int arr[], int result[]) {
        Stack<Integer> s = new Stack<>();
        for (int i=arr.length-1; i>=0; i--) {
            //we always the write the opposite of breaking condn
            //next time i don't forget where i have to use ! sign before s.isEmpty()
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,4,2,17,9,12};
        int result[] = new int[arr.length];
        nxtGreater(arr, result);

        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();


        // if (Next Greater Right) {
        //     Refer Above Program
        // } else (Next Greater Left) {
        //     Reverse the traversal/for loop
        // }
        
        // if (Next Smaller Right) {
        //     Reverse the comparison
        // } else (Next Smaller Left) {
        //     Reverse the traversal as well as comparison
        // }

    }
}