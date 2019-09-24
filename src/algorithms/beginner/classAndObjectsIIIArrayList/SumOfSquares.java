package algorithms.beginner.classAndObjectsIIIArrayList;

import java.util.List;

public class SumOfSquares {
  /**
   * @author Qihao He
   * @date 09/24/2019
   * https://app.laicode.io/app/problem/635
   */
  public int sumOfSquare(List<Integer> list) {
    if (list == null || list.size() == 0) {
      return 0;
    }
    int sum = 0;
    for (int num: list) {
      sum += num * num;
    }
    return sum;
  }
}
