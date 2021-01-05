package leetcode;

import java.io.*;
import java.util.StringTokenizer;

public class LC_397_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int ans = 0;
        while (true){
            if(num == 1){
                System.out.println(ans);
                return;
            }else if(num == 3){
                System.out.println(ans + 2);
                return;
            }else {
                if(num % 2 == 0){
                    num /= 2;
                }else {
                    if((num - 1) % 2 == 0){
                        num -= 1;
                    }else if((num + 1) % 2 == 0){
                        num += 1;
                    }else {
                        num -= 1;
                    }
                }
            }
            ans++;
        }

        //Queue<Pair> q = new LinkedList<Pair>();
        //boolean [] isVisited = new boolean [num+10];
//        Queue<Integer> q = new LinkedList<Integer>();
//        int [] isVisited = new int [num+10];
//
//        int [] dx = {2, 1, -1};
//        int ans = 0;

//        q.add(num);
//        isVisited[num] = 1;

//        while (!q.isEmpty()){
//
//            int p = q.poll();
//            if(p == 1){
//                ans = isVisited[p] - 1;
//                System.out.println(ans);
//                return;
//            }
//
//            for(int i = 0; i < 3; i ++){
//                int vx = 0;
//
//                if(p % 2 == 0 && i > 0) continue;
//                if(p % 2 != 0 && i == 0) continue;
//                if(p % 2 == 0 && i == 0){
//                    vx = p / dx[i];
//                }else if(p % 2 != 0 && i > 0){
//                    vx = p + dx[i];
//                }
//
//                if(vx <= 0 || vx >= isVisited.length || isVisited[vx] > 0) continue;
//                isVisited[vx] = isVisited[p] + 1;
//                q.add(vx);
//            }

//            Pair p = q.poll();
//            if(p.x == 1){
//                ans = p.count;
//                System.out.println(ans);
//                return;
//            }
//
//            for(int i = 0; i < 3; i ++){
//                int vx = 0;
//
//                if(p.x % 2 == 0 && i > 0) continue;
//                if(p.x % 2 != 0 && i == 0) continue;
//                if(p.x % 2 == 0 && i == 0){
//                    vx = p.x / dx[i];
//                }else if(p.x % 2 != 0 && i > 0){
//                    vx = p.x + dx[i];
//                }
//
//                if(vx <= 0 || vx >= isVisited.length || isVisited[vx]) continue;
//                isVisited[vx] = true;
//                q.add(new Pair(vx, p.count + 1));
//            }
        //}


    }

    static class Pair{
        public int x;
        public int count;
        public Pair(int x, int count){
            this.x = x;
            this.count = count;
        };
    }
}
