package cero.ninja.aws.analyze;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class StackTrace {
    public StackTrace() {
        new Exception("Constructor").printStackTrace();
    }

    public String myHandler() {
        new Exception("Handler").printStackTrace();
        Arrays.stream(ManagementFactory.getThreadMXBean().dumpAllThreads(true, true))
                .forEach(System.out::println);
        return "SUCCESS";
    }
}
