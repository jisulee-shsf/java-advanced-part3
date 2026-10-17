package parallel;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class ParallelMain3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        SumTask sumTask1 = new SumTask(1, 4);
        SumTask sumTask2 = new SumTask(5, 8);

        Future<Integer> future1 = executorService.submit(sumTask1);
        Future<Integer> future2 = executorService.submit(sumTask2);

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        int sum = result1 + result2;

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);

        executorService.close();
    }

    private static class SumTask implements Callable<Integer> {

        private int startValue;
        private int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() {
            log("작업 시작");
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }
            log("작업 완료 - result = " + sum);
            return sum;
        }
    }
    /*
    19:33:03.587 [pool-1-thread-1] 작업 시작
    19:33:03.587 [pool-1-thread-2] 작업 시작
    19:33:03.606 [pool-1-thread-2] calculate 5 -> 50
    19:33:03.606 [pool-1-thread-1] calculate 1 -> 10
    19:33:04.611 [pool-1-thread-2] calculate 6 -> 60
    19:33:04.611 [pool-1-thread-1] calculate 2 -> 20
    19:33:05.614 [pool-1-thread-2] calculate 7 -> 70
    19:33:05.616 [pool-1-thread-1] calculate 3 -> 30
    19:33:06.618 [pool-1-thread-2] calculate 8 -> 80
    19:33:06.624 [pool-1-thread-1] calculate 4 -> 40
    19:33:07.630 [pool-1-thread-1] 작업 완료 - result = 100
    19:33:07.630 [pool-1-thread-2] 작업 완료 - result = 260
    19:33:07.638 [     main] time: 4101ms, sum: 360
    */
}
