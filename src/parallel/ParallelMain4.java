package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain4 {

    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorCount: " + processorCount + ", commonPool: " + commonPool.getParallelism());

        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .parallel()
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
    /*
    03:44:37.547 [     main] processorCount: 8, commonPool: 7
    03:44:37.559 [     main] calculate 6 -> 60
    03:44:37.560 [ForkJoinPool.commonPool-worker-4] calculate 5 -> 50
    03:44:37.560 [ForkJoinPool.commonPool-worker-2] calculate 8 -> 80
    03:44:37.560 [ForkJoinPool.commonPool-worker-1] calculate 3 -> 30
    03:44:37.560 [ForkJoinPool.commonPool-worker-5] calculate 7 -> 70
    03:44:37.560 [ForkJoinPool.commonPool-worker-6] calculate 1 -> 10
    03:44:37.560 [ForkJoinPool.commonPool-worker-3] calculate 2 -> 20
    03:44:37.560 [ForkJoinPool.commonPool-worker-7] calculate 4 -> 40
    03:44:38.575 [     main] time: 1013ms, sum: 360
    */
}
