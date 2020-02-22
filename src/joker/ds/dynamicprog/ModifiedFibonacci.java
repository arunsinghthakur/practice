package joker.ds.dynamicprog;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ModifiedFibonacci {

    static String fibonacciModified(int t1, int t2, int n) {
        BigInteger[] dp = new BigInteger[n];
        dp[0] = BigInteger.valueOf(t1);
        dp[1] = BigInteger.valueOf(t2);
        int k = 2;
        while (k < n) {
            dp[k] = dp[k - 2].add(dp[k - 1].multiply(dp[k - 1]));
            ++k;
        }
        return dp[n - 1].toString();
    }

    public static void main(String[] args) {
        System.out.print(fibonacciModified(0, 1, 10));
    }
}
