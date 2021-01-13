package hacker_rank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HR_The_Grid_Search {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    static String gridSearch(String[] G, String[] P) {

        String ans = "NO";

        int gHeight = G.length;
        int gWidth = G[0].length();
        int pHeight = P.length;
        int pWidth = P[0].length();

        String pFirst = P[0];

        for(int i = 0; i < gHeight; i++){
            for(int j = 0; j < gWidth; j++){
                if(G[i].charAt(j) == pFirst.charAt(0)){
                    int correctStack = 0;
                    for(int k = 0; k < pFirst.length(); k++){
                        if(j+k < 0 || j+k >= gWidth) continue;
                        if(G[i].charAt(j+k) == pFirst.charAt(k)){
                            correctStack++;
                        }
                    }
                    if(correctStack == pFirst.length()){
                        boolean temp = validation(G, P, i, j);
                        if(temp) return "YES";
                    }
                }
            }
        }

        return ans;
    }

    static boolean validation(String[] G, String[] P, int startY, int startX) {
        for(int i = 1; i < P.length; i++){
            for(int j = 0; j < P[0].length(); j++){
                if(i < 0 || i >= G.length || j < 0 || j >= G[0].length() || startY+i < 0 || startY+i >= G.length || j < 0 || j+startX >= G[0].length()) return false;
                if(G[startY+i].charAt(j+startX) != P[i].charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
