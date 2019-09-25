package algorithms.sort;
/**
 * @author: Qihao He
 * @date 06/21/2019
 */
public class MoveZero {
	private int[] moveZero(int[] array) {
		// Write your solution here
		if(array.length == 0){
			return array;
		}
		int leftBound = 0;
		int rightBound = array.length - 1;
		while(leftBound <= rightBound){
			if(array[leftBound] != 0){
				leftBound++;
			}else if(array[rightBound] == 0){
				rightBound--;
			}else{
				swap(array, leftBound++, rightBound--);
			}
		}
		return array;
	}

	private void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] =  array[right];
		array[right] = temp;
	}
}