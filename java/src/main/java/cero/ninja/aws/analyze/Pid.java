package cero.ninja.aws.analyze;

import java.lang.management.ManagementFactory;
import java.util.concurrent.atomic.AtomicLong;

public class Pid {
    static AtomicLong counter = new AtomicLong();

    public String myHandler() {
        long count = counter.incrementAndGet();
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Name: " + name);
        System.out.println("Count: " + count);
        return "SUCCESS";
    }
}
