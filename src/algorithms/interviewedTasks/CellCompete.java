package algorithms.interviewedTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class CellCompete {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        if (states == null || states.length == 0) {
            List<Integer> result = new LinkedList<>();
            return result;
        }
        int[] helper = new int[states.length];
        for (int i = 0; i < days; i++) {
            helper = copyArray(states, helper);
            for (int j = 0; j < states.length; j++) {
                if (j == 0) {
                    if (helper[1] == 0) {
                        states[j] = 0;
                    } else {
                        states[j] = 1;
                    }
                } else if (j == states.length - 1) {
                    if (helper[states.length - 2] == 0) {
                        states[j] = 0;
                    } else {
                        states[j] = 1;
                    }
                } else {
                    if (helper[j - 1] != helper[j + 1]) {
                        states[j] = 1;
                    } else {
                        states[j] = 0;
                    }
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int num : states) {
            result.add(num);
        }
        return result;
        // WRITE YOUR CODE HERE
    }
    private int[] copyArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }
    // METHOD SIGNATURE ENDS
}