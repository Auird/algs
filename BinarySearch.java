package algs;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class BinarySearch {

    public static int indexOf(int[] a, int key) {
        int low_index = 0;
        int high_index = a.length - 1;

        while(low_index <= high_index){
            int mid_index = (low_index + high_index) / 2;
            if(key > a[mid_index]){
                low_index = mid_index + 1;
            }else if(key < a[mid_index]){
                high_index = mid_index - 1;
            }else{
                return mid_index;
            }
        }
        return -1;
    }

    //not working perfectly.
    @Deprecated
    public static int binSearch(int[] a, int key, int low, int high){
        int mid = (low + high) / 2;
        if(key < a[mid]){
            return binSearch(a, key, low, mid - 1);
        }else if(key > a[mid]){
            return binSearch(a, key, mid + 1, high);
        }else if (key == a[mid]){
            return mid;
        }else{
            return -1;
        }
        //return -1;
    }


    public static void main(String[] args) {

        int[] testSample = {2,3,4,5,6,7};
        StdOut.println(indexOf(testSample, 8));
        //StdOut.println(binSearch(testSample, 8, 0, testSample.length - 1));
    }
}