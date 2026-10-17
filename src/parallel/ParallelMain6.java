package parallel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain6 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService requestPool = Executors.newFixedThreadPool(100);
        ExecutorService loginPool = Executors.newFixedThreadPool(400);

        int nThread = 3;
        for (int i = 1; i <= nThread; i++) {
            String requestName = "request" + i;
            requestPool.submit(() -> logic(requestName, loginPool));
            Thread.sleep(100);
        }
        requestPool.close();
        loginPool.close();
    }

    private static void logic(String requestName, ExecutorService logicPool) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        List<Future<Integer>> futures = IntStream.rangeClosed(1, 4)
                .mapToObj(i -> logicPool.submit(() -> HeavyJob.heavyTask(i, requestName)))
                .toList();

        int sum = futures.stream()
                .mapToInt(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();

        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime) + ", sum: " + sum);
    }
    /*
    06:52:51.821 [pool-1-thread-1] [request1] START
    06:52:51.851 [pool-1-thread-2] [request2] START
    06:52:51.854 [pool-2-thread-4] [request1] 4 -> 40
    06:52:51.854 [pool-2-thread-6] [request2] 2 -> 20
    06:52:51.854 [pool-2-thread-1] [request1] 1 -> 10
    06:52:51.854 [pool-2-thread-5] [request2] 1 -> 10
    06:52:51.854 [pool-2-thread-2] [request1] 2 -> 20
    06:52:51.854 [pool-2-thread-7] [request2] 3 -> 30
    06:52:51.854 [pool-2-thread-8] [request2] 4 -> 40
    06:52:51.854 [pool-2-thread-3] [request1] 3 -> 30
    06:52:51.954 [pool-1-thread-3] [request3] START
    06:52:51.954 [pool-2-thread-9] [request3] 1 -> 10
    06:52:51.955 [pool-2-thread-10] [request3] 2 -> 20
    06:52:51.955 [pool-2-thread-11] [request3] 3 -> 30
    06:52:51.955 [pool-2-thread-12] [request3] 4 -> 40
    time: 1010, sum: 100
    time: 1031, sum: 100
    time: 1004, sum: 100
    */
}
