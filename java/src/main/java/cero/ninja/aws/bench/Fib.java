package cero.ninja.aws.bench;

import java.math.BigDecimal;

public class Fib {
    public String myHandler() {
        System.out.println("Start warming up");
        long sum = 0;
        sum += fib(38);
        System.out.println("Finish warming up");

        long start = System.nanoTime();
        sum += fib(38);
        long duration = System.nanoTime() - start;

        BigDecimal durationSec = BigDecimal.valueOf(duration).divide(BigDecimal.valueOf(1000 * 1000 * 1000));
        System.out.println("Duration: " + durationSec);
        System.out.println("Result: " + sum);

        return durationSec.toString();
    }

    int fib(int n) {
        if (n < 2) return n;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        new Fib().myHandler();
    }
}
