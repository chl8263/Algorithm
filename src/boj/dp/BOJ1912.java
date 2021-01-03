package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int [] arr = new int [num + 5];
        int [] sum = new int [num + 5];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i ++){
            int num2 = Integer.parseInt(st2.nextToken());
            arr[i] = num2;
        }

        sum[1] = arr[1];
        for(int i = 2; i <= num; i ++){
            int tSum = arr[i] + sum[i-1];
            if(arr[i] > tSum){
                sum[i] = arr[i];
            }else {
                sum[i] = tSum;
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= num; i ++){
            ans = Math.max(ans, sum[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
