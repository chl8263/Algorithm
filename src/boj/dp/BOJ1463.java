package boj.dp;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        boolean [] isvisited = new boolean[num+1];

//        int [] dy = new int []{0, 0, -1, 1};
//        int [] dx = new int []{-1, 1, 0, 0};
        int [] dx = new int []{3, 2, -1};

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, num));
        isvisited[num] = true;

        int ans = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(p.x == 1){
                ans = p.count;
                break;
            }
            for(int i = 0; i < 3; i ++){
                int vx;
                if(i == 2){
                    vx = dx[i] + p.x;
                }else {
                    int temp = p.x % dx[i];
                    if(temp == 0){
                        vx = p.x / dx[i];
                        if(vx == 0) continue;
                    }else continue;
                }

                if(vx <= 0 || vx > num || isvisited[vx]) continue;
                q.add(new Pair(p.count + 1, vx));
                isvisited[vx] = true;
            }
        }

        System.out.println(ans);
        bw.flush();
    }

    static class Pair{
        int x;
        int count;
        public Pair(int count, int x){
            this.count = count;
            this.x = x;
        }
    }
}

// BFS solution
//public class BOJ1463 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int num = Integer.parseInt(st.nextToken());
//
//        boolean [] isvisited = new boolean[num+1];
//
////        int [] dy = new int []{0, 0, -1, 1};
////        int [] dx = new int []{-1, 1, 0, 0};
//        int [] dx = new int []{3, 2, -1};
//
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(0, num));
//        isvisited[num] = true;
//
//        int ans = 0;
//
//        while(!q.isEmpty()){
//            Pair p = q.poll();
//
//            if(p.x == 1){
//                ans = p.count;
//                break;
//            }
//            for(int i = 0; i < 3; i ++){
//                int vx;
//                if(i == 2){
//                    vx = dx[i] + p.x;
//                }else {
//                    int temp = p.x % dx[i];
//                    if(temp == 0){
//                        vx = p.x / dx[i];
//                        if(vx == 0) continue;
//                    }else continue;
//                }
//
//                if(vx <= 0 || vx > num || isvisited[vx]) continue;
//                q.add(new Pair(p.count + 1, vx));
//                isvisited[vx] = true;
//            }
//        }
//
//        System.out.println(ans);
//        bw.flush();
//    }
//
//    static class Pair{
//        int x;
//        int count;
//        public Pair(int count, int x){
//            this.count = count;
//            this.x = x;
//        }
//    }
//}

