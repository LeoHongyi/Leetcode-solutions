package Algorithms.Array;

import java.util.Arrays;
/**
  Method: two pointers
**/
public class RemoveElement {
  public int[] removeElement(int[] input, int value) {
    // Write your solution here
    // sanity check
    if (input == null) {
      return null;
    }
    int slow = 0;
    for (int i = 0; i < input.length; i++) {
      if (input[i] != value) {
        input[slow++] = input[i];
      }
    }
    return Arrays.copyOfRange(input, 0, slow);
  }
}
