package hacker_rank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class HR_Bear_and_Steady_Gene_x {
    // Complete the steadyGene function below.
    static int steadyGene(String gene) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('G', 0);
        map.put('A', 0);
        map.put('C', 0);
        map.put('T', 0);

        for(int i = 0; i <= gene.length(); i++){
            switch (gene.charAt(i)){
                case 'G' :
                    map.put('G', map.get('G')+1);
                    break;
                case 'A' :
                    map.put('A', map.get('A')+1);
                    break;
                case 'C' :
                    map.put('C', map.get('C')+1);
                    break;
                case 'T' :
                    map.put('T', map.get('T')+1);
                    break;
            }
        }



        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
