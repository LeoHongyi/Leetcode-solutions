package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int startIndex = 0;
        for(int num : nums1) {
            int index = binarySearch(nums2, num, startIndex);
            if (index != -1) {
                list.add(num);
            } else {
                startIndex = index;
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }
    private int binarySearch(int[] array, int target, int startIndex) {
        int left = startIndex;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}