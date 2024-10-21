//{ Driver Code Starts
// Initial Template for Java

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
            int res = new Solution().findSubArraySum(k, arr);

            System.out.print(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int findSubArraySum(int k, int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Update the running prefix sum

            // Check if there is a previous prefix sum such that sum - k exists in the map
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store the current prefix sum into the map, or update its count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}