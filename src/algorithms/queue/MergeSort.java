package algorithms.queue;

public void sort(LinkedList<Integer> s1) {
  Deque<Integer> one = s1;
  Deque<Integer> two = new ArrayDeque<>();
  Deque<Integer> three = new ArrayDeque<>();
  mergeSort(one,two,three,one.size());
}

private void mergeSort(Deque<Integer> original, Deque<Integer> secondHalf, Deque<Integer> helper, int originalSize) {
  // original: the stack to be sorted
  // after mergeSort all value go back to original stack
  // secondHalf: the stack used to store the second half of
  //             original stack
  // helper: the stack used to help merge method
  // originalSize: the # of elements in original stack need to be sorted

  if (originalSize<=1) {
    return;
  }

  int secondHalfSize = originalSize / 2;

  // push half elements from original into secondHalf
  int i = secondHalfSize;
  while (i>0) {
    secondHalf.addFirst(original.removeFirst());
    i--;
  }

  // new originalSize is its previous value
  // minus secondHalfSize
  originalSize -= secondHalfSize;
  mergeSort(original,secondHalf,helper,originalSize);
  mergeSort(secondHalf,original,helper,secondHalfSize);
  merge(original,originalSize,secondHalf,secondHalfSize,helper);
}



private void merge(Deque<Integer> original, int originalSize,Deque<Integer> secondHalf, int secondHalfSize, Deque<Integer> helper) {
  /** first we merge element from original and secondHalf into helper,
      smallest pops first:
      e.g.:
      before:
      original:   2 1| <-- the '|' mark represents the end of stack
      secondHalf: 3 4|
      helper:        |
      after:
      original:          |
      secondHalf:        |
      helper:     4 3 2 1|
      THE HELPER IS IN DESCENDING ORDER!!!
   */
  int i = originalSize;
  int j = secondHalfSize;
  while (i>0 || j>0) {
    if (j<=0 || i>0 && original.getFirst()<secondHalf.getFirst()) {
      helper.addFirst(original.removeFirst());
      i--;
    } else {
      helper.addFirst(secondHalf.removeFirst());
      j--;
    }
  }

  /** then we pops element from helper back to original stack
      e.g.:
      before:
      original:          |
      secondHalf:        |
      helper:     4 3 2 1|
      after:
      original:   1 2 3 4|
      secondHalf:        |
      helper:            |
      NOW ORIGINAL IS SORTED
   */
  int k = originalSize + secondHalfSize;
  while (k>0) {
    original.addFirst(helper.removeFirst());
    k--;
  }
}
