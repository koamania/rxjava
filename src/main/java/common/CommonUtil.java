package common;

import java.util.concurrent.TimeUnit;

public class CommonUtil {

    public static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException ignore) {
        }
    }
}
