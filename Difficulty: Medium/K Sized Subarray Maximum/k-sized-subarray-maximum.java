//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int nums[]) {
        int i = 0;  // Left pointer (start of the sliding window)
        int j = 0;  // Right pointer (end of the sliding window)
        int n = nums.length;  // Length of the input array
        Deque<Integer> temp = new LinkedList<>();  // Deque to store potential maximum elements for the current window
        ArrayList<Integer> ans = new ArrayList<>();  // Result list to store the maximum of each window
        while (j < n) {
            // Step 1: Add the current element nums[j] to the deque in descending order
            // If the deque is empty, simply add the element
            if (temp.isEmpty()) {
                temp.add(nums[j]);
            } else {
                // Remove elements from the back of the deque while the new element is greater
                // This ensures the deque maintains a descending order
                while (temp.size() > 0 && nums[j] > temp.peekLast()) {
                    temp.removeLast();
                }
                // Add the current element to the back of the deque
                temp.add(nums[j]);
            }
            
            // Step 2: If the current window size is less than 'k', simply expand the window
            if (j - i + 1 < k) {
                j++;
            } 
            // Step 3: When the window reaches size 'k', we need to process the window
            else if (j - i + 1 == k) {
                // The maximum of the current window is at the front of the deque
                ans.add(temp.peek());

                // Step 4: Slide the window by moving 'i' and 'j'
                // Remove the element nums[i] from the deque if it is at the front
                int elementTobeRemoved = nums[i];
                if (!temp.isEmpty() && temp.peek() == elementTobeRemoved) {
                    temp.removeFirst();  // Remove the front element if it's no longer in the window
                }

                // Step 5: Slide the window forward
                i++;
                j++;
            }
        }
        return ans;  // Return the result list containing the maximums for each window

    }
}