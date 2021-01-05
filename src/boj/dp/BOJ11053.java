package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int arr [] = new int[num + 10];
        int dArr [] = new int[num + 10];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i ++){
            int num2 = Integer.parseInt(st2.nextToken());
            arr[i] = num2;
        }

        dArr[1] = 1;
        for(int i = 2; i <= num; i ++){
            if(arr[i] > arr[i-1]) dArr[i] = dArr[i-1]+1;
            else dArr[i] = dArr[i-1];
        }

        bw.flush();
    }
}
