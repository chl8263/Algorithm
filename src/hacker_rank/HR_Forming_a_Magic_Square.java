package hacker_rank;

import java.io.IOException;

public class HR_Forming_a_Magic_Square {
    public static void main(String[] args) throws IOException {

        int [][] s = {
                {4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}
        };

        System.out.println(formingMagicSquare(s));

    }

    static int formingMagicSquare(int[][] s) {
        // 3 x 3 magic square
        //possible magicsquare is 8
        int[][] magic0 = {{8,1,6}, {3,5,7}, {4,9,2}};
        int[][] magic1 = {{6,1,8}, {7,5,3}, {2,9,4}};
        int[][] magic2 = {{4,9,2}, {3,5,7}, {8,1,6}};
        int[][] magic3 = {{2,9,4}, {7,5,3}, {6,1,8}};
        int[][] magic4 = {{8,3,4}, {1,5,9}, {6,7,2}};
        int[][] magic5 = {{4,3,8}, {9,5,1}, {2,7,6}};
        int[][] magic6 = {{6,7,2}, {1,5,9}, {8,3,4}};
        int[][] magic7 = {{2,7,6}, {9,5,1}, {4,3,8}};

        int[] sum = new int[8];

        //compare given parameter and possible magicsquare
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[0] += Math.abs(s[i][j] - magic0[i][j]);
                sum[1] += Math.abs(s[i][j] - magic1[i][j]);
                sum[2] += Math.abs(s[i][j] - magic2[i][j]);
                sum[3] += Math.abs(s[i][j] - magic3[i][j]);
                sum[4] += Math.abs(s[i][j] - magic4[i][j]);
                sum[5] += Math.abs(s[i][j] - magic5[i][j]);
                sum[6] += Math.abs(s[i][j] - magic6[i][j]);
                sum[7] += Math.abs(s[i][j] - magic7[i][j]);
            }
        }

        int min = sum[0];

        for (int i = 0; i < sum.length; i++) {
            if (min > sum[i]) {
                min = sum[i];
            }
        }

        return min;
    }

//    static int formingMagicSquare(int[][] s) {
//        int a = s[0][0] + s[1][1] + s[2][2];
//        int a2 = s[0][2] + s[1][1] + s[2][0];
//        int a3 = s[0][1] + s[1][1] + s[2][1];
//        int a4 = s[1][0] + s[1][1] + s[1][2];
//        int a5 = s[0][0] + s[0][1] + s[0][2];
//        int a6 = s[0][0] + s[1][0] + s[2][0];
//        int a7 = s[0][2] + s[1][2] + s[2][2];
//        int a8 = s[2][0] + s[2][1] + s[2][2];
//
//        int [] arr = new int[]{a, a2, a3, a4, a5, a6 , a7, a8};//, a6, a7, a8};
//        int ans = Integer.MAX_VALUE;
//        for(int i = 0; i < arr.length; i++){
//            int standard = arr[i];
//            int temp = 0;
//            for(int j = 0; j < arr.length; j++){
////                if(standard - arr[j] >= 0){
////                    temp += standard - arr[j];
////                }
////                else temp += Math.abs(standard - arr[j]);
//                temp += Math.abs(standard - arr[j]);
//            }
//            ans = Math.min(ans, temp);
//        }
//
//        if(ans == Integer.MAX_VALUE) ans = 0;
//
//        return ans;
//    }

}
