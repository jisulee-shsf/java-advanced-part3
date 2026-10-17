package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain5 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        int nThread = 3;
        for (int i = 1; i <= nThread; i++) {
            String requestName = "request" + i;
            executorService.submit(() -> logic(requestName));
            Thread.sleep(100);
        }
        executorService.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime) + ", sum: " + sum);
    }
}
