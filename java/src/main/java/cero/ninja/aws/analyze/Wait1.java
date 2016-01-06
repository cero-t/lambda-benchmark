package cero.ninja.aws.analyze;

public class Wait1 {
    static long origin = System.currentTimeMillis();

    public String myHandler() {
        try {
            System.out.println("Before wait: " + (System.currentTimeMillis() - origin));
            Thread.sleep(10000);
            System.out.println("After wait: " + (System.currentTimeMillis() - origin));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}
