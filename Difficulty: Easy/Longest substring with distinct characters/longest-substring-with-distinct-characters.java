//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubstrDistinctChars(String s) {
        int i = 0;  // left pointer of the sliding window
        int j = 0;  // right pointer of the sliding window
        HashMap<Character, Integer> m = new HashMap<>();  // map to store the frequency of characters in the current window
        int maxi = 0;  // variable to store the maximum length of the substring without repeating characters
        
        // Start sliding the window
        while (j < s.length()) {
            // Add current character to the map and increase its count
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
            
            // If all characters in the current window are unique, update the maximum length
            if (m.size() == j - i + 1) {
                maxi = Math.max(maxi, j - i + 1);  // update the maximum length of a valid substring
                j++;  // expand the window by moving the right pointer
            } 
            // If there are duplicate characters (i.e., map size is less than window size), shrink the window
            else if (m.size() < j - i + 1) {
                // Shrink the window by removing characters from the left
                while (m.size() < j - i + 1) {
                    char elementToBeRemoved = s.charAt(i);  // get the leftmost character to be removed
                    m.put(elementToBeRemoved, m.get(elementToBeRemoved) - 1);  // decrease its count
                    
                    // If the count of the character becomes 0, remove it from the map
                    if (m.get(elementToBeRemoved) == 0) {
                        m.remove(elementToBeRemoved);
                    }
                    i++;  // move the left pointer to shrink the window
                }
                j++;  // expand the window by moving the right pointer after shrinking
            }
        }
        return maxi;  // return the maximum length of substring without repeating characters
    }
}
