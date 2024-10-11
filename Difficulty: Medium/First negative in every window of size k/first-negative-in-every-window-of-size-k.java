//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int K) {
        int i = 0;
        int j = 0;
        LinkedList<Long> temp = new LinkedList<>();
        long[] result = new long[N - K + 1];
        int index = 0; // Use index to keep track of result array position
    
        while (j < N) {
            // Add negative numbers to the temp list
            if (arr[j] < 0) {
                temp.add(arr[j]);
            }
    
            // If the window size is less than K, simply increment j
            if (j - i + 1 < K) {
                j++;
            }
            // When window size is K
            else if (j - i + 1 == K) {
                // If temp is empty, add 0 to the result, else add the first negative number
                if (temp.isEmpty()) {
                    result[index] = 0;
                } else {
                    result[index] = temp.peek();
                }
                index++;
    
                // Slide the window
                long elementTobeRemoved = arr[i];
                i++;
                j++;
                
                // If the element to be removed is the first negative number, remove it from temp
                if (!temp.isEmpty() && temp.peek() == elementTobeRemoved) {
                    temp.remove();
                }
            }
        }
        return result;
    }

}