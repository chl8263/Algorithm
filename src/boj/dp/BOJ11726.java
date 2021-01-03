package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int [] arr = new int [1005];
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= num; i ++){
            arr[i] = (arr[i-1] + arr[i - 2]) % 10007; // mod 연산의 특성을 이용하여 여기서 연산을 미리해도 ok
        }

        int ans = arr[num];   // % 10007 를 여기서 나누면 integer overflow 가 발생한다.

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
