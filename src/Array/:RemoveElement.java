/**
  Method: two pointers
**/
public class Solution {
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
