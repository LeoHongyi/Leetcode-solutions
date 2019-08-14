// Question 1. Find all possible decode ways.
// The decoding scheme is:
// 1 -> A
// 2 -> B
// …
// 10 -> J
// 11 -> K
// 12 -> L
// …
// 21 -> U
// 22 -> V
// ...
// 26 -> Z

// e.g. Given input "1121"
// It can be decoded as
// [ "AABA",
//   "AAU",
//   "ALA",
//   "KBA",
//   "KU"
// ]
//  This problem can be solve using dfs
//Observation: smallest number is 1, largest is 26
// we can split the digits into 1 bits or 2bits, 
// for 1 bits: the num can not start with 0;
// for 2 bits: the num must be smaller than 26
// 		1123 
// 	1/   123          11 /    23
//    1/   1/  23       11 /2/ 3    11/23   
// 1/1/2/3
// Time  2^(n-1)        Space O(n)
public class Solution {
private void printAllDecodeWays(String input) {
	if(input == null || input.length() == 0) return;
	StringBuilder sb = new StringBuilder();
	dfs(0, input, sb);
}

private void dfs(int start, String input, StringBuilder sb) {
	if(start == input.length()) {
	System.out.println(sb.toString());
	return;
}
// number cannot start with 0
/ "0xxx"
// "1"
if(input.charAt(start) == 0) return;
int size = sb.length();
for(int i = start; i < start + 2 && i < input.length() ; i++) {
	if(i == start) {
// one bit
	sb.append((Char)(‘A’ + input.charAt(i) - ‘1’));
	dfs(i + 1, input, sb);
	sb.deleteCharAt(sb.length() - 1);
} else {
	// two bits
	int n = Integer.valueOf(input.substring(start, i + 1);
	if( n <= 26)) {
	sb.append((char)(n - 1 + ‘A’));
	dfs(i + 1, input, sb);
	sb.setLength(size);
}
}
}
