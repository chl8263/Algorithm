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
//        for(int i = 0; i < w.length(); i ++){
//            int a = w.charAt(i) - 40;
//            System.out.print(w.charAt(i) + " " + a);
//            System.out.println();
//            arr = new char[w.length()];
//            isVisited = new boolean[w.length()];
//            dfs(w, 0);
//            for(int j  = 0; j < arr.length; j ++) {
//                System.out.print(arr[i]);
//            }
//        }

        List tempArr = new ArrayList();
        for(int i = 0; i < w.length(); i ++){
            tempArr.add(w.charAt(i));
        }
        Collections.sort(tempArr);
        String sortedW = "";
        for(int i = 0; i < tempArr.size(); i ++){
            sortedW += tempArr.get(i);
        }

        //System.out.println(w+" -> ===========");
        arr = new char[w.length()];
        isVisited = new boolean[w.length()];
        strList = new ArrayList<String>();
        flag = true;
        index = -1;
        ans = "no answer";
        dfs(w, 0, sortedW);
//        Collections.sort(strList);
//        for(String str : strList){
//            if(str.compareTo(w) > 0){
//                return str;
//            }
//        }
//        for(int j  = 0; j < arr.length; j ++) {
//            System.out.print(arr[j]);
//        }

//        System.out.println();
//        System.out.println("===========");
        return ans;
    }

    static char [] arr = new char [0];
    static List<String> strList;
    static boolean [] isVisited = new boolean [0];
    static int index = -1;
    static boolean flag = true;
    static String ans = "no answer";

    static void dfs(String w, int count, String sortedW) {
        if(flag) {
            if (count == w.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    sb.append(arr[i]);
                    //System.out.print(arr[i]);
                }
                strList.add(sb.toString());
                if (sb.toString().equals(w)) {
                    index = strList.size();
                }

                if(strList.size()-1 == index){
                    ans = strList.get(strList.size()-1);
                    flag = false;
                }
                //System.out.println();
                return;
            }
            for (int i = 0; i < w.length(); i++) {
                if (isVisited[i]) continue;
                isVisited[i] = true;
                arr[count] = sortedW.charAt(i);
                dfs(w, count + 1, sortedW);
                isVisited[i] = false;
            }
        }
    }

}
