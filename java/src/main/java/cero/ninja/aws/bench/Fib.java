package cero.ninja.aws.bench;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fib {
    public String myHandler(InputStream in, Context context) {
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
        Integer[] integerArray = {1, 62, 31, 1, 54, 31};
        Stream.of(integerArray).forEach(String::valueOf);
    }
}
