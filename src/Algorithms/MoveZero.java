package Algorithms;

public class MoveZero {
	private static int[] moveZero(int[] array) {
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

	private static void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] =  array[right];
		array[right] = temp;
	}
}