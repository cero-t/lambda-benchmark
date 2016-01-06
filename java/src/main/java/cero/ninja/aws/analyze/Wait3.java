package cero.ninja.aws.analyze;

public class Wait3 {
    static long origin = System.currentTimeMillis();

    public Wait3() {
        try {
            System.out.println("Before wait: " + (System.currentTimeMillis() - origin));
            Thread.sleep(2000);
            System.out.println("After wait: " + (System.currentTimeMillis() - origin));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String myHandler() {
        System.out.println("Called: " + (System.currentTimeMillis() - origin));
        return "SUCCESS";
    }
}
