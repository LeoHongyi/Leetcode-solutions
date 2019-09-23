package algorithms.depthFirstSearch;
import java.util.List;
import java.util.ArrayList;
/**
 IP address are canonically represented in dot-decimal notation,
 which consists of four decimal numbers, each ranging from 0 to 255,
 separated by dots (".") e.g. 172.16.254.1
 Besides, leading zeros in the IPv4 is invalid, For Example, the address
 172.16.254.01 is invalid.
 Method: algorithms.depthFirstSearch
 recursion tree level 4 levels, each level determine the ip partition in 4 parts of the IP
 each level decide to put what number between 0-255 in the result
 **/
public class RestoreIpAddresses {
	public List<String> Restore(String ip) {
		List<String> result  = new ArrayList();
		if (ip == null || ip.length() == 0 || ip.length() < 4 || ip.length() > 12) {
			return result;
		}
		helper(result, ip, new StringBuilder(), 0, 4);
		return result;
	}
	private void helper(List<String> result, String s, StringBuilder sb, int index, int dot){
		if (index == s.length() || dot == 0) {
			if (index == s.length() && dot == 0) {
				result.add(sb.toString());
			}
			return;
		}
		if (dot < 4) {
			sb.append(".");
		}
		int len = sb.length();
		// physical meaning: index: the start index of current level IP partition
		// physical meaning: i: the start index of next level IP partition
		for (int i = index + 1 ; i <= Math.min(index + 3, s.length()); i++) {
			// not valid ip that starts with 0
			if (i != index + 1 && s.charAt(index) == '0') {
				break;
			}
			// check valid ip and append to StringBuilder
			int num = Integer.parseInt(s.substring(index, i));
			if (num >= 0 && num <= 255) {
				sb.append(num);
				helper(result, s, sb, i, dot - 1);
				sb.setLength(len);
			}
		}
	}
}

