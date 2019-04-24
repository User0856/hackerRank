// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
static String isValid(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        int count=0;
        for (char aChar : chars) {
            if(map.containsKey(aChar)){
                count = map.get(aChar);

                map.put(aChar, ++count);
            } else{
                map.put(aChar, 1);
            }
        }

        int[] arr = new int[map.size()];

        int index = 0;

        for (Integer integer : map.values()) {
            arr[index++] = integer;
        }

        int notEqual = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[0]!=arr[i]){
                notEqual++;
            }
            if(notEqual>=2){
                return "NO";
            }

        }

            return "YES";
        }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
