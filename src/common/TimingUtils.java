package common;

import java.util.concurrent.Callable;

public class TimingUtils {
    public static <T> T timeMethod(String label, Callable<T> task) throws Exception {
        try {
            long startTime = System.nanoTime();
            T result = task.call();
            long durationMs = (System.nanoTime() - startTime) / 1_000_000;
            System.out.println(label + " - Execution time: " + durationMs + " ms");
            return result;
        } catch (Exception e) {
            System.out.println(label + " - Execution failed");
            throw e;
        }
    }
}
