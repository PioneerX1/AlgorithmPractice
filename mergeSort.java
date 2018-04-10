import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSort {

  //static void mergeArray(int []a1, int []b1, int M) {
  public static void main(String [] args) {

    // this array is used just to initialize array b
    int []c = {30, 32, 34, 36, 38, 40, 42, 44, 46, 48};

    int []a = {3, 5, 6, 9, 12, 14, 18, 20, 25, 28};
    int []b = new int[a.length * 2];
    for(int i=0; i < a.length; i++) {
      b[i] = c[i];
    }


    System.out.println("---ARRAY A---");
    for(int number : a) {
      System.out.print(number + " ");
    }
    System.out.println("---");
    System.out.println("---ARRAY B---");
    for(int number : b) {
      System.out.print(number + " ");
    }
    System.out.println("---");

    int aPointer = a.length - 1;
    int bPointer = a.length - 1;  // start at same place

    for(int i = b.length -1; i >= 0; i--) {

      if (aPointer < 0 && bPointer < 0) {   // maybe don't even need to check for this?
        break;  // done, array is merged and sorted
      } else if (aPointer < 0) {
        b[i] = b[bPointer];
        bPointer--;
      } else if (bPointer < 0) {
        b[i] = a[aPointer];
        aPointer--;
      } else {
        if (b[bPointer] >= a[aPointer]) {
          b[i] = b[bPointer];
          bPointer--;
        } else {
          b[i] = a[aPointer];
          aPointer--;
        }
      }
    }

    System.out.println("---FINAL ARRAY B---");
    for(int number : b) {
      System.out.print(number + " ");
    }
    System.out.println("---");

    // create 2 int pointers, one for a, one for b
    // create int to document total # of integers in final array
    // start both pointers at highest number of both arrays
    // loop from the top of b array, decrementing down
      // if both a and b pointers < 0
        // break loop, we're done
      // else if a pointer < 0
        // break loop, no need for further action since we are working out the b array
      // else if b pointer < 0
        // fill in rest of b array with remaining contents of a array, working down till finished
      // else
        // each iteration, compare a and b pointers
        // if b pointer is >= a pointer
          // assign b pointer's value to current b index
          // decrement b pointer
        // else
          // assign a pointer's value to current b index
          // decrement a pointer



  }
}
