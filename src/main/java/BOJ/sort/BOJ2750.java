package BOJ.sort;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2750 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(num));
        bw.flush();
    }
}

