package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int arr [][] = new int [num][3];
        int arr2 [][] = new int [num][3];

        for(int i = 0; i < num; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < num; j++) {

            }
        }


        bw.write(num);
        bw.flush();
    }
}
