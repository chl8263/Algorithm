package hacker_rank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HR_Absolute_Permutation {
    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {

        int num = (k * 2) == 0 ? 1 : (k * 2);
        if(n % num != 0) return new int[]{-1};
        int [] ans = new int[n];
        for(int i = 1; i <= n; i++){
            int t = i % num;
            if(t > 0 && t <= k){
                ans[i-1] = i + k;
            }else if (t == 0 || t > k){
                ans[i-1] = i - k;
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
