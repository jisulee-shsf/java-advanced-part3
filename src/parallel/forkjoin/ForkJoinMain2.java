package parallel.forkjoin;

import java.util.List;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain2 {

    public static void main(String[] args) {
//        int processorCount = Runtime.getRuntime().availableProcessors();
//        ForkJoinPool commonPool = ForkJoinPool.commonPool();
//        log("processorCount: " + processorCount + ", commonPool: " + commonPool.getParallelism());

        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();
        log("[생성] " + data);

        SumTask task = new SumTask(data);
        Integer result = task.invoke();
        log("result: " + result);
    }
    /*
    02:50:50.354 [     main] [생성] [1, 2, 3, 4, 5, 6, 7, 8]
    02:50:50.383 [     main] [분할] [1, 2, 3, 4, 5, 6, 7, 8] -> LEFT: [1, 2, 3, 4], RIGHT: [5, 6, 7, 8]
    02:50:50.391 [     main] [분할] [5, 6, 7, 8] -> LEFT: [5, 6], RIGHT: [7, 8]
    02:50:50.391 [ForkJoinPool.commonPool-worker-1] [분할] [1, 2, 3, 4] -> LEFT: [1, 2], RIGHT: [3, 4]
    02:50:50.392 [     main] [처리 시작] [7, 8]
    02:50:50.392 [ForkJoinPool.commonPool-worker-2] [처리 시작] [5, 6]
    02:50:50.392 [ForkJoinPool.commonPool-worker-1] [처리 시작] [3, 4]
    02:50:50.392 [ForkJoinPool.commonPool-worker-3] [처리 시작] [1, 2]
    02:50:50.409 [ForkJoinPool.commonPool-worker-2] calculate 5 -> 50
    02:50:50.409 [     main] calculate 7 -> 70
    02:50:50.409 [ForkJoinPool.commonPool-worker-3] calculate 1 -> 10
    02:50:50.409 [ForkJoinPool.commonPool-worker-1] calculate 3 -> 30
    02:50:51.414 [     main] calculate 8 -> 80
    02:50:51.414 [ForkJoinPool.commonPool-worker-2] calculate 6 -> 60
    02:50:51.414 [ForkJoinPool.commonPool-worker-3] calculate 2 -> 20
    02:50:51.414 [ForkJoinPool.commonPool-worker-1] calculate 4 -> 40
    02:50:52.425 [     main] [처리 완료] [7, 8] -> sum: 150
    02:50:52.425 [ForkJoinPool.commonPool-worker-1] [처리 완료] [3, 4] -> sum: 70
    02:50:52.425 [ForkJoinPool.commonPool-worker-2] [처리 완료] [5, 6] -> sum: 110
    02:50:52.425 [ForkJoinPool.commonPool-worker-3] [처리 완료] [1, 2] -> sum: 30
    02:50:52.434 [ForkJoinPool.commonPool-worker-1] LEFT[30] / RIGHT[70] -> sum: 100
    02:50:52.434 [     main] LEFT[110] / RIGHT[150] -> sum: 260
    02:50:52.435 [     main] LEFT[100] / RIGHT[260] -> sum: 360
    02:50:52.435 [     main] result: 360
    */
}
