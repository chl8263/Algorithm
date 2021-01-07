package hacker_rank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HR_Non_Divisible_Subset {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int num = Integer.parseInt(st.nextToken());

//        int k = 3;
//        List<Integer> s = new ArrayList<Integer>();
//        s.add(1);
//        s.add(7);
//        s.add(2);
//        s.add(4);

        int k = 7;
        List<Integer> s = new ArrayList<Integer>();
        s.add(278);
        s.add(576);
        s.add(496);
        s.add(727);
        s.add(410);
        s.add(124);
        s.add(338);
        s.add(149);
        s.add(209);
        s.add(702);
        s.add(282);
        s.add(718);
        s.add(771);
        s.add(575);
        s.add(436);

        int ans = Result.nonDivisibleSubset(k, s);

        System.out.println(ans);

    }
}

class Result {
    List<Integer> s;
    boolean [] isUsed;
    int [] arr = new int[2];
    int ans = 0;
    boolean [] correctArr = new boolean[1000000000];

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

        Result r = new Result();
        r.s = s;
        r.isUsed = new boolean[r.s.size()];

        r.dfs(0, 0, k);

        for(int i = 0; i < r.correctArr.length; i++){
            if(r.correctArr[i])
                System.out.print(i + " ");
        }

        return r.ans;

    }

    public void dfs(int count, int start, int k){
        if(count == 2) {
//            for(int i = 0; i < arr.length; i++){
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();

            if((arr[0] + arr[1]) % k != 0 && arr[0] % k != 0 && arr[1] % k != 0){
                System.out.println(arr[0] + " " + arr[1]);
                if(!correctArr[arr[0]]){
                    ans++;
                    correctArr[arr[0]] = true;
                }
                if(!correctArr[arr[1]]){
                    ans++;
                    correctArr[arr[1]] = true;
                }
            }
            return;
        }

        for(int i = start; i < s.size(); i ++){
            if(isUsed[i]) continue;
            arr[count] = s.get(i);
            isUsed[i] = true;
            dfs(count + 1, i + 1, k);
            isUsed[i] = false;
        }

    }
}

