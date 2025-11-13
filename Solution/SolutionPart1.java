package Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/* Algorithm description --------------------------------------------------------------------------------
*
*
* read all lines (reports)
* for each report we need to find out if it's safe or not
* a report being safe means it's either ALL ascending or ALL descending,
* to know which (asc or desc) we have we check the first two elements,
* we have 3 possibilities, report[0] < report[1] meaning we need the entire report to be in ascending order
* otherwise  report[0] > report[1] meaning desc order
* OR finally report[0] == report[1] in which case we can just return false the report can't be safe.
* we assume the report is safe until we find a bad level.
* then depending the first two levels we enter one of the three if blocks, we go through the array and compare
* every item to the next if we find a problem we return false; if we finish the loop the function return true
* So we add 1 to the total and go for the next report!
**
* */

public class SolutionPart1 {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("input.txt"));
        int total = 0;
        for(String line : lines){
            String[] nums1 = line.split(" ");
            int[] nums2 = Arrays.stream(nums1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(isSafe(nums2))
                total++;
        }
        System.out.println(total);
    }

    private static boolean isSafe(int[] nums2) {
        int n = nums2.length;
        boolean flag = true;
        if(nums2[0] < nums2[1]){
            for(int i = 0; i<n - 1; i++){
                if(nums2[i] >= nums2[i + 1] || nums2[i] + 3 < nums2[i+1]){
                    return false;
                }
            }
        }
        else if(nums2[0] > nums2[1]){
            for(int i = 0; i<n - 1; i++){
                if(nums2[i] <= nums2[i + 1] || nums2[i] - 3 > nums2[i+1]){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
}
