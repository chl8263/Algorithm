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

        for (int i = 0; i < num; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 0){
                    arr2[i][j] = arr[i][j];
                }else {
                    int prev1 = 0;
                    int prev2 = 0;
                    if(j == 0){
                        prev1 = arr2[i-1][1];
                        prev2 = arr2[i-1][2];
                    }else if(j == 1){
                        prev1 = arr2[i-1][0];
                        prev2 = arr2[i-1][2];
                    }else if(j == 2){
                        prev1 = arr2[i-1][0];
                        prev2 = arr2[i-1][1];
                    }
                    if(prev1 > prev2){
                        arr2[i][j] = prev2 + arr[i][j];
                    }else {
                        arr2[i][j] = prev1 + arr[i][j];
                    }
                }
            }
        }

        int ans;
        ans = arr2[num-1][0] > arr2[num-1][1] ? arr2[num-1][1] : arr2[num-1][0];
        ans = ans > arr2[num-1][2] ? arr2[num-1][2] : ans;

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
