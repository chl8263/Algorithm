package hacker_rank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HR_Emas_Supercomputer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        String[] grid = new String[y];

        for(int i = 0; i < y; i++) {
            grid[i] = br.readLine();
        }

        int ans = twoPluses(grid);
        System.out.println(ans);

        //bw.write(num);
        bw.flush();
    }

    static final int [] dx = new int[]{0, 0, 1, -1};
    static final int [] dy = new int[]{1, -1, 0, 0};

    static int twoPluses(String[] grid) {

        int ans = 1;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                boolean [][] isVisited = new boolean[grid.length][grid[0].length()];
                int t = search(0, i, j, grid, isVisited);
                ans = Math.max(ans, t);
            }
        }
        return ans;
    }

    static int search(int count, int y, int x, String[] grid, boolean [][] isVisited){

        if (y == 0 || y >= grid.length-1 || x == 0 || x >= grid[0].length()-1) return 1;
        char root = grid[y].charAt(x);
        if(root == 'B') return 1;

        int [] currentY = new int[]{y, y, y, y};
        int [] currentX = new int[]{x, x, x, x};
        boolean flag = true;
        List<Pair> tempVisited = new ArrayList<Pair>();

        int ans = 1;

        while (flag) {
            tempVisited.clear();
            for (int i = 0; i < 4; i++) {
                int vy = dy[i] + currentY[i];
                int vx = dx[i] + currentX[i];
                if (vy < 0 || vy >= grid.length || vx < 0 || vx >= grid[0].length() || isVisited[vy][vx] || grid[vy].charAt(vx) == 'B') {
                    flag = false;
                }
                if(flag){
                    currentY[i] = vy;
                    currentX[i] = vx;
                    tempVisited.add(new Pair(vy, vx));
                    if(i == 3 && tempVisited.size() == 4) {
                        ans += 4;
                        for(Pair p : tempVisited){
                            isVisited[p.y][p.x] = true;
                        }
                    }
                }
            }
        }

        if(count == 0 && ans > 1){
            int s_ans = 1;
            for(int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length(); j++) {
                    int t = search(count + 1, i, j, grid, isVisited);
                    s_ans = Math.max(s_ans, t);
                }
            }
            ans *= s_ans;
        }

        return ans;
    }

    static class Pair{
        int x;
        int y;

        public Pair(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}
