package hacker_rank;

import java.io.*;
import java.util.*;

public class HR_Bigger_is_Greater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        for(int i = 0; i < num; i ++){
            String str = br.readLine();
            String ans = biggerIsGreater(str);
            System.out.println(ans);
        }

        bw.write(num);
        bw.flush();
    }

    static String biggerIsGreater(String w) {
        for(int i = 0; i < w.length(); i ++){
            int a = w.charAt(i) - 40;
            System.out.print(w.charAt(i) + " " + a);
            System.out.println();
            arr = new int[w.length()];
            isVisited = new boolean[w.length()];
            dfs(w, 0, 0);
            for(int j  = 0; j < arr.length; j ++) {
                System.out.print(arr[i]);
            }
        }

        //System.out.println(w+" -> ===========");
        arr = new char[w.length()];
        isVisited = new boolean[w.length()];
        strList = new ArrayList<String>();
        dfs(w, 0);
        Collections.sort(strList);
        for(String str : strList){
            if(str.compareTo(w) > 0){
                return str;
            }
        }
//        for(int j  = 0; j < arr.length; j ++) {
//            System.out.print(arr[j]);
//        }

//        System.out.println();
//        System.out.println("===========");
        return "no answer";
    }

    static char [] arr = new char [0];
    static List<String> strList;
    static boolean [] isVisited = new boolean [0];
    static void dfs(String w, int count) {

        if(count == w.length()){
            StringBuilder sb = new StringBuilder();
            for(int i  = 0; i < arr.length; i ++) {
                sb.append(arr[i]);
                //System.out.print(arr[i]);
            }
            strList.add(sb.toString());
            //System.out.println();
            return;
        }
        for(int i = 0; i < w.length(); i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            arr[count] = w.charAt(i);
            dfs(w, count + 1);
            isVisited[i] = false;
        }
    }

}
