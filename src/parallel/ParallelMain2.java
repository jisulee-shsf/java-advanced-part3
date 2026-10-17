package parallel;

import static util.MyLogger.log;

public class ParallelMain2 {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        SumTask sumTask1 = new SumTask(1, 4);
        SumTask sumTask2 = new SumTask(5, 8);

        Thread thread1 = new Thread(sumTask1, "thread-1");
        Thread thread2 = new Thread(sumTask2, "thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        log("main 스레드 대기 완료");

        int sum = sumTask1.result + sumTask2.result;

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }

    private static class SumTask implements Runnable {

        private int startValue;
        private int endValue;
        private int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }
            result = sum;
            log("작업 완료 - result = " + result);
        }
    }
    /*
    19:06:08.338 [ thread-1] 작업 시작
    19:06:08.338 [ thread-2] 작업 시작
    19:06:08.359 [ thread-1] calculate 1 -> 10
    19:06:08.359 [ thread-2] calculate 5 -> 50
    19:06:09.362 [ thread-2] calculate 6 -> 60
    19:06:09.362 [ thread-1] calculate 2 -> 20
    19:06:10.366 [ thread-1] calculate 3 -> 30
    19:06:10.366 [ thread-2] calculate 7 -> 70
    19:06:11.371 [ thread-1] calculate 4 -> 40
    19:06:11.371 [ thread-2] calculate 8 -> 80
    19:06:12.379 [ thread-2] 작업 완료 - result = 260
    19:06:12.379 [ thread-1] 작업 완료 - result = 100
    19:06:12.379 [     main] main 스레드 대기 완료
    19:06:12.388 [     main] time: 4114ms, sum: 360
    */
}
