package clickautomation;

public class Wait {

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }
}
