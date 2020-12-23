package BOJ.dp;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int [] isvisited = new int [num];

        Queue<Pair> q = new LinkedList<>();

        bw.write(Integer.toString(num));
        bw.flush();
    }

    class Pair{
        int y;
        int x;
        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}

