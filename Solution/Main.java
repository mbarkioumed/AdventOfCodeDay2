package Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\pc\\Documents\\AdventofCode\\Solution\\input.txt"));
        int total = 0;
        for(String line : lines){
            String[] nums1 = line.split(" ");
            int[] nums2 = Arrays.stream(nums1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = nums2.length;
            boolean flag = true;
            if(nums2[0] < nums2[1]){
                for(int i = 0; i<n - 1; i++){
                    if(nums2[i] >= nums2[i + 1] || nums2[i] + 3 < nums2[i+1]){
                        flag = false;
                    }
                }
            }
            else if(nums2[0] > nums2[1]){
                for(int i = 0; i<n - 1; i++){
                    if(nums2[i] <= nums2[i + 1] || nums2[i] - 3 > nums2[i+1]){
                        flag = false;
                    }
                }
            }else{
                flag = false;
            }
            if(flag)
                total++;
        }
        System.out.println(total);
    }
}
