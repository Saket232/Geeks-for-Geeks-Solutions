//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int i = 0;  // left pointer of the window
        int j = 0;  // right pointer of the window
        Map<Character, Integer> m = new HashMap<>();  // map to store character counts in the current window
        int maxi = -1;  // variable to store the maximum length of the substring with exactly k distinct characters

        // Start sliding the window
        while (j < s.length()) {
            // Add current character to the map and increase its count
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
            
            // If the size of the map is less than k, we expand the window
            if (m.size() < k) {
                j++;
            }
            // If the size of the map is exactly k, we update the maximum length
            else if (m.size() == k) {
                maxi = Math.max(maxi, j - i + 1);  // update the maximum length of substring
                j++;  // expand the window
            }
            // If the size of the map exceeds k, we shrink the window from the left
            else if (m.size() > k) {
                // Shrink the window by removing characters from the left
                while (m.size() > k) {
                    char elementToBeRemoved = s.charAt(i);  // get the leftmost character to be removed
                    m.put(elementToBeRemoved, m.get(elementToBeRemoved) - 1);  // decrease its count
                    
                    // If the character count becomes 0, remove it from the map
                    if (m.get(elementToBeRemoved) == 0) {
                        m.remove(elementToBeRemoved);
                    }
                    i++;  // shrink the window
                }
                j++;  // expand the window
            }
        }
        
        // If maxi remains -1, it means there was no valid substring, otherwise we return the maximum length
        return maxi;
    }
}
