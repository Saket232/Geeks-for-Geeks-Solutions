//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String p, String s) {

		int i = 0;
		int j = 0;
		int patSize = p.length();
		Map<Character, Integer> m = new HashMap<>();
		int result = 0;
		int k = 0;
		while (k < p.length()) {
			if (m.containsKey(p.charAt(k))) {
				int var = m.get(p.charAt(k));
				var = var + 1;
				m.put(p.charAt(k), var);
			} else {
				m.put(p.charAt(k), 1);
			}
			k++;
		}

		int count = m.size();
		while (j < s.length()) {
			char ch = s.charAt(j);
			if (m.containsKey(ch)) {
				int var = m.get(ch);
				var = var - 1;
				m.put(ch, var);
				if (var == 0) {
					count--;
				}
			}

			if (j - i + 1 < patSize) {
				j++;
			} else if (j - i + 1 == patSize) {
				if (count == 0) {
					result++;
				}
				if (m.containsKey(s.charAt(i))) {
					m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
					if (m.get(s.charAt(i)) == 1) {
						count++;
					}
				}
				j++;
				i++;
			}
		}
		return result;
    }
}