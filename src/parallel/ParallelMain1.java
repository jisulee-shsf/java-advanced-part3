package parallel;

import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain1 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
    /*
    18:14:24.566 [     main] calculate 1 -> 10
    18:14:25.576 [     main] calculate 2 -> 20
    18:14:26.581 [     main] calculate 3 -> 30
    18:14:27.585 [     main] calculate 4 -> 40
    18:14:28.589 [     main] calculate 5 -> 50
    18:14:29.593 [     main] calculate 6 -> 60
    18:14:30.598 [     main] calculate 7 -> 70
    18:14:31.602 [     main] calculate 8 -> 80
    18:14:32.613 [     main] time: 8117ms, sum: 360
    */
}
