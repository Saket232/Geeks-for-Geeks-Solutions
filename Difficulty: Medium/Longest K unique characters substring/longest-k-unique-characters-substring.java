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
        int i = 0;
        int j = 0;
        Map<Character, Integer> m = new HashMap<>();
        int maxi = -1;
        while(j < s.length()) {
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
            
            if (m.size() < k) {
                j++;
            } else if(m.size() == k) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } else if(m.size() > k) {
                while(m.size() > k) {
                    char elementToBeRemoved = s.charAt(i);
                    m.put(elementToBeRemoved, m.get(elementToBeRemoved) - 1);
                    if(m.get(elementToBeRemoved) == 0) {
                        m.remove(elementToBeRemoved);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxi;
    }
}