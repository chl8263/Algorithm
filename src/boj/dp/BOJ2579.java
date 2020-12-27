package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][3];

        for(int i = 0; i < num; i ++){
            int next = Integer.parseInt(br.readLine());
            arr[i][0] = next;
        }

        for(int i = 0; i < num; i++){
            if(i == 0){
                arr[0][1] = arr[0][0];
            }else if(i == 1){
                arr[1][1] = arr[1][0];
                arr[1][2] = arr[0][0] + arr[1][0];
            }else {
                arr[i][1] = Math.max(arr[i-2][1], arr[i-2][2]) + arr[i][0];
                arr[i][2] = arr[i-1][1] + arr[i][0];
            }
        }

        int ans = Math.max(arr[num-1][1], arr[num-1][2]);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

