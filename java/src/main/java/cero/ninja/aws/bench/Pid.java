package cero.ninja.aws.bench;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.util.concurrent.atomic.AtomicLong;

public class Pid {
    static AtomicLong counter = new AtomicLong();

    public String myHandler(InputStream in, Context context) {
        long count = counter.incrementAndGet();
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        System.out.println(pid + " / " + count);
        return "SUCCESS";
    }

    public static void main(String[] args) {
        new Pid().myHandler(null, null);
    }
}
