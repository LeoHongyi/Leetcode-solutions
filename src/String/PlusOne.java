package String;
/**
 Method: int to char, Integer.valueOf(String), char to int
 **/
public class PlusOne {
    public int[] plus(int[] digits) {
        // Write your solution here
        if (digits == null || digits.length == 0) {
            return digits;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }
        int temp = Integer.valueOf(sb.toString());
        temp++;
        String s = temp + "";
        int[] result = new int[s.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = s.charAt(i) - '0';
        }
        return result;
    }
}
