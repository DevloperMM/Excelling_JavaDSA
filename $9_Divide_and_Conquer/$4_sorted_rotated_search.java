package $9_Divide_and_Conquer;

public class $4_sorted_rotated_search {
    public static int search(int arr[], int tar, int si, int ei) {

        //base case
        if (si > ei) {
            return -1;
        }

        //kaam
        int mid = si + (ei - si)/2;

        //FOUND
        if (arr[mid] == tar) {
            return mid;
        }

        //case-1 : mid on L1
        if (arr[si] <= arr[mid]) {
            //case-a : left of L1
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            }
            //case-b : right of mid
            else {
                return search(arr, tar, mid+1, ei);
            }
        }

        //case-2 : mid on L2
        else {
            //case-c : right of L1
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            }
            //case-d : left of mid
            else {
                return search(arr, tar, si, mid-1);
            }
        }
        
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 6;
        int tar_idx = search(arr, target, 0, arr.length-1);
        System.out.println(tar_idx);
    }
}
