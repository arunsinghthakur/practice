package joker.ds.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Problem1 {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] q) {
        long[] r = new long[n + 2];
        for (int i = 0; i < q.length; i++) {
            int a = q[i][0];
            int b = q[i][1];
            int k = q[i][2];

            r[a] += k;
            r[b + 1] -= k;
        }
        final long[] s = {Integer.MIN_VALUE};
        final long[] p = {0};
        Arrays.stream(r).forEach(e -> {
            p[0] += e;
            s[0] = s[0] > p[0] ? s[0] : p[0];
        });
        return s[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
