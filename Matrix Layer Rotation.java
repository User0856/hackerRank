/*
Solution for:
https://www.hackerrank.com/challenges/matrix-rotation-algo/
Thanks to: 
https://github.com/kasi1996arun
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();
        Integer[][] array = new Integer[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array[i][j]=matrix.get(i).get(j);
            }
        }

        int x=0;
                for (int i = 0; i < Math.min(m, n) / 2; i++) {
                    int actualR = r%(2*(m + n - 4*i) - 4);
                    for(int rotatin = 0; rotatin<actualR; rotatin++){

                        for (int j = i; j < n - i - 1; j++) {
                            int tmp = array[i][j];
                            array[i][j] = array[i][j + 1];
                            array[i][j + 1] = tmp;
                        }

                        for (int j = i; j < m - i - 1; j++) {
                            int tmp = array[j][n - i - 1];
                            array[j][n - i - 1] = array[j + 1][n - i - 1];
                            array[j + 1][n - i - 1] = tmp;
                        }

                        for (int j = n - i - 1; j > i; j--) {
                            int tmp = array[m - i - 1][j];
                            array[m - i - 1][j] = array[m - i - 1][j - 1];
                            array[m - i - 1][j - 1] = tmp;
                        }

                        for (int j = m - i - 1; j > i + 1; j--) {
                            int tmp = array[j][i];
                            array[j][i] = array[j - 1][i];
                            array[j - 1][i] = tmp;
                        }
                        
                    }
                }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
