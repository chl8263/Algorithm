package hacker_rank;

import java.io.*;

public class HR_Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().replace(" ", "");

        double num = Math.sqrt(str.length());
        int max;
        int min;
        char [][] arr;
        if(num % 1 == 0){
            max = min = (int) num;
        }else {
            max = min = (int) num + 1;
        }

        arr = new char[min][max];

        for(int i = 0; i < min*max; i++){
            int y = i / max;
            int x = i % max;
            char temp;
            if(i >= str.length()) {
                temp = ' ';
            } else {
                temp = str.charAt(i);
            }
            arr[y][x] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < max; i++){
            for(int j = 0; j < min; j++){
                if(arr[j][i] != ' ')
                    sb.append(arr[j][i]);
            }
            sb.append(" ");
        }
        bw.flush();
    }
}
