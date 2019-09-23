package algorithms.string;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aBit;
        int bBit;
        int carry = 0;
        int result;
        // when i, j inbound, and carry are still valid
        while (i >= 0 || j >= 0 || carry == 1) {
            // if i, j inbound, get char to int
            // else, use 0
            aBit = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            bBit = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = aBit ^ bBit ^ carry;
            // if 1,1,1 = 3,  1,1,0 = 2, carry = 1
            // else, carrry = 0;
            carry = ((aBit + bBit + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}
