package Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/* Algorithm description --------------------------------------------------------------------------------
 *
 *
 * Same as Part1 except this time we add a loop that removes one element and checks if the new report is safe
 * If either the original report or one of the newReports is safe we consider the report safe and 1 to the total
 *
 * */
public class SolutionPart2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\pc\\Documents\\AdventofCode\\Solution\\input.txt"));
        int total = 0;
        for(String line : lines){
            String[] nums = line.split(" ");

            int[] reportAsList = Arrays.stream(nums)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean flag = false;
            int n = reportAsList.length;

            if(isSafe(reportAsList)) {
                total++;
                continue;
            }

            for(int i = 0; i<n; i++){
                int[] newReport = removeIndex(reportAsList, i);
                if(isSafe(newReport)) {
                    total++;
                    break;
                }
            }
        }
        System.out.println(total);
    }

    private static boolean isSafe(int[] reportAsList) {
        int n = reportAsList.length;
        boolean safe = true;


        if(reportAsList[0] < reportAsList[1]){
            for(int i = 0; i<n - 1; i++){
                if (reportAsList[i] >= reportAsList[i + 1] || reportAsList[i] + 3 < reportAsList[i + 1]) {
                    safe = false;
                    break;
                }
            }
        }
        else if(reportAsList[0] > reportAsList[1]){
            for(int i = 0; i<n - 1; i++){
                if (reportAsList[i] <= reportAsList[i + 1] || reportAsList[i] - 3 > reportAsList[i + 1]) {
                    safe = false;
                    break;
                }
            }
        }else{
            safe = false;
        }
        return safe;
    }

    private static int[] removeIndex(int[] arr, int i) {
        int[] result = new int[arr.length - 1];
        for (int j = 0, k = 0; j < arr.length; j++) {
            if (j != i) {
                result[k++] = arr[j];
            }
        }
        return result;
    }
}
