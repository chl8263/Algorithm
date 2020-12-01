package BOJ;

import com.sun.tools.javac.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args){

        int [] dy = new int[]{0, 0, 1, -1};
        int [] dx = new int[]{1, -1, 0, 0};

        String[][] board = new String[][] {
                {"A", "B", "T", "T", "T"},
                {"T", "C", "D", "E", "T"},
                {"T", "C", "D", "F", "T"},
                {"B", "A", "H", "G", "F"},
                {"C", "D", "E", "F", "G"}
        };

        int result = 0;

        for(int k = 0; k < 5; k ++){
            for(int l = 0; l < 5; l ++) {

                Queue<Pair<Integer, Integer>> queue = new LinkedList();

                Boolean[][] isVisited = new Boolean[][] {
                        {false, false, false, false, false},
                        {false, false, false, false, false},
                        {false, false, false, false, false},
                        {false, false, false, false, false},
                        {false, false, false, false, false}
                };

                queue.add(new Pair(k, l));
                isVisited[k][l] = true;

                int tempAns = 1;
                while (queue.isEmpty()) {
                    Pair<Integer, Integer> p = queue.poll();
                    for (int i = 0; i < 3; i++) {
                        int vy = dy[i] + p.fst;
                        int vx = dx[i] + p.snd;
                        if (vy < 0 || vy >= 5 || vx < 0 || vx >= 5 || isVisited[vy][vx]) continue;
                        if (board[vy][vx].charAt(0) <= board[p.fst][p.snd].charAt(0)) continue;
                        queue.add(new Pair(p.fst, p.snd));
                        tempAns++;
                    }
                }

                result = Math.max(result, tempAns);
            }
        }
        System.out.println(result);
    }
}