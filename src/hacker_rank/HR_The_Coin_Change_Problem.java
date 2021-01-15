package hacker_rank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HR_The_Coin_Change_Problem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Long> c = new ArrayList<Long>();
        for(int i = 0; i < m; i++){
            c.add(Long.parseLong(st2.nextToken()));
        }



        System.out.println(Result2.getWays((long)num, c));

        bw.flush();
    }
}

class Result2 {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    static long ans = 0;

    public static long getWays(Long n, List<Long> c) {
        recursion(0L, n, c, new ArrayList<Long>());
        return ans;
    }

    public static void recursion(Long sum, Long goal, List<Long> c, List<Long> list) {
        if(sum == goal) {
            for(Long a : list){
                System.out.print(a + " ");
            }
            System.out.println();
            ans++;
            return;
        }
        if(sum > 10) {
            return;
        }

        for(Long t : c){
            List list2 = new ArrayList<Long>();
            for(long a : list){
                list2.add(a);
            }
            list2.add(t);
            recursion(sum + t, goal, c, list2);
        }
    }

}