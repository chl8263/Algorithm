package hacker_rank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HR_Almost_Sorted {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {

        int prev = arr[0];
        int start = 0;
        for(int i = 1; i < arr.length; i++){
            if(prev > arr[i]){
                start = i-1;
                break;
            }
            prev = arr[i];
        }

        int end_prev = arr[arr.length - 1];
        int end = arr.length - 1;
        for(int i = arr.length - 2; i >= 0; i--){
            if(end_prev < arr[i]){
                end = i+1;
                break;
            }
            end_prev = arr[i];
        }

        if (swap(arr, start, end)){
            System.out.println("yes");
            System.out.print("swap " + (start+1) + " " + (end+1));
            return;
        }

        if (reverse(arr, start, end)) {
            System.out.println("yes");
            System.out.print("reverse " + (start + 1) + " " + (end+1));
            return;
        }
        System.out.println("no");
    }

    static boolean reverse(int [] arr, int start, int end){
        int i = start;
        int j = end;
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return validate(arr);
    }

    static boolean swap(int[] arr, int start, int end) {
        int one = arr[start];
        int two = arr[end];
        arr[end] = one;
        arr[start] = two;
        if(validate(arr)) return true;
        else {
            arr[start] = one;
            arr[end] = two;
            return false;
        }
    }

    static boolean validate(int[] arr) {
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(prev > arr[i]) return false;
            prev = arr[i];
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

        BufferedReader f = new BufferedReader(new FileReader(new File("C:\\text.txt")));
        String[] s = f.readLine().split(" ");

        int[] te = new int[s.length];
        for(int i = 0; i < te.length; i++) {
            te[i] = Integer.parseInt(s[i]);
        }

        almostSorted(te);

        scanner.close();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int num = Integer.parseInt(st.nextToken());
//
//
//        bw.write(num);
//        bw.flush();
//    }
}


//import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.regex.*;
//
//public class Solution {
//
//    // Complete the almostSorted function below.
//    static void almostSorted(int[] arr) {
//
//        int prev = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            if(prev > arr[i]){
//                // s : sort
//                int[] arr2 = arr.clone();
//                int one = arr[i-1];
//                int two = arr[i];
//                arr2[i] = one;
//                arr2[i-1] = two;
//                // e : sort
//                boolean temp = validate(arr2);
//                if (temp){
//                    System.out.println("yes");
//                    System.out.print("swap " + (i) + " " + (i+1));
//                    return;
//                } else {
//                    // s : reverse
//                    int[] arr3 = arr.clone();
//                    StringBuilder sb = new StringBuilder();
//                    int s_index = i-1;
//                    int e_index = i-1;
//                    int prev2 = arr[i-1];
//                    sb.append(prev2);
//                    for(int j = i; j < arr.length; j++){
//                        if(prev2 < arr[j]) break;
//                        prev2 = arr[j];
//                        e_index++;
//                        sb.append(prev2);
//                    }
//                    if(e_index - s_index <= 1) {
//                        System.out.println("no");
//                        return;
//                    }else {
//                        String reversedString = sb.toString();
//                        for(int j = reversedString.length()-1; j >= 0; j--){
//                            arr3[e_index-j] = Integer.parseInt(String.valueOf(reversedString.charAt(j)));
//                        }
//                        boolean temp2 = validate(arr3);
//                        if (temp2){
//                            System.out.println("yes");
//                            System.out.print("reverse " + (s_index + 1) + " " + (e_index+1));
//                            return;
//                        }else {
//                            System.out.println("no");
//                            return;
//                        }
//                    }
//                    // e : reverse
//                }
//            }
//            prev = arr[i];
//        }
//
//    }
//
//    static boolean validate(int[] arr) {
//        int prev = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            if(prev > arr[i]) return false;
//            prev = arr[i];
//        }
//        return true;
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        almostSorted(arr);
//
//        scanner.close();
//    }
//}
