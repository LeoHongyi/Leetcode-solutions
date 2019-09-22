public class SumOfSquares {
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
