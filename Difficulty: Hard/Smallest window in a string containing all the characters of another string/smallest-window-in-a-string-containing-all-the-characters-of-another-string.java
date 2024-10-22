//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        while (test > 0) {
            String s1 = scan.next();
            String s2 = scan.next();

            System.out.println(new Solution().smallestWindow(s1, s2));
            test--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public String smallestWindow(String s, String t) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> m = new HashMap<>();
        int mini = Integer.MAX_VALUE;  // Initialize to MAX_VALUE for minimum window size comparison
        String minSubStr = "";  // To store the minimum window substring

        // Populate the frequency map for string `t`
        for (int k = 0; k < t.length(); k++) {
            m.put(t.charAt(k), m.getOrDefault(t.charAt(k), 0) + 1);
        }

        int count = m.size();  // Number of unique characters to match

        // Sliding window approach
        while (j < s.length()) {
            char k = s.charAt(j);  // Current character in `s`
            
            // If the character is part of `t`, update the frequency map
            if (m.containsKey(k)) {
                m.put(k, m.get(k) - 1);
                if (m.get(k) == 0) {
                    count--;  // One character's frequency has been fully matched
                }
            }

            // When all characters of `t` are matched in the current window
            while (count == 0) {
                // Try to minimize the window by removing characters from the left (i pointer)
                if (j - i + 1 < mini) {  // Check if current window is the smallest
                    mini = j - i + 1;  // Update minimum length
                    minSubStr = s.substring(i, j + 1);  // Store the current minimum window
                }

                // Shrink the window by moving the left pointer `i`
                char elementToBeRemoved = s.charAt(i);
                if (m.containsKey(elementToBeRemoved)) {
                    m.put(elementToBeRemoved, m.get(elementToBeRemoved) + 1);
                    if (m.get(elementToBeRemoved) > 0) {
                        count++;  // If character count becomes positive, it means we need it again
                    }
                }
                i++;  // Move the left pointer
            }
            
            j++;  // Expand the window by moving the right pointer
        }

        // If no valid window is found, `minSubStr` will remain empty
        return minSubStr.isEmpty() ? "-1" : minSubStr;
    }
}
