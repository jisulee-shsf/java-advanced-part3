package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ForkJoinMain1 {

    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();
        log("[생성] " + data);

        long startTime = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool(10);
        SumTask task = new SumTask(data);

        Integer result = pool.invoke(task);
        pool.close();

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + result);
        log("pool: " + pool);
    }
    /*
    01:29:16.684 [     main] [생성] [1, 2, 3, 4, 5, 6, 7, 8]
    01:29:16.719 [ForkJoinPool-1-worker-1] [분할] [1, 2, 3, 4, 5, 6, 7, 8] -> LEFT: [1, 2, 3, 4], RIGHT: [5, 6, 7, 8]
    01:29:16.720 [ForkJoinPool-1-worker-1] [분할] [5, 6, 7, 8] -> LEFT: [5, 6], RIGHT: [7, 8]
    01:29:16.720 [ForkJoinPool-1-worker-2] [분할] [1, 2, 3, 4] -> LEFT: [1, 2], RIGHT: [3, 4]
    01:29:16.721 [ForkJoinPool-1-worker-1] [처리 시작] [7, 8]
    01:29:16.721 [ForkJoinPool-1-worker-3] [처리 시작] [5, 6]
    01:29:16.721 [ForkJoinPool-1-worker-2] [처리 시작] [3, 4]
    01:29:16.721 [ForkJoinPool-1-worker-4] [처리 시작] [1, 2]
    01:29:16.735 [ForkJoinPool-1-worker-2] calculate 3 -> 30
    01:29:16.735 [ForkJoinPool-1-worker-3] calculate 5 -> 50
    01:29:16.735 [ForkJoinPool-1-worker-4] calculate 1 -> 10
    01:29:16.735 [ForkJoinPool-1-worker-1] calculate 7 -> 70
    01:29:17.739 [ForkJoinPool-1-worker-2] calculate 4 -> 40
    01:29:17.739 [ForkJoinPool-1-worker-3] calculate 6 -> 60
    01:29:17.739 [ForkJoinPool-1-worker-4] calculate 2 -> 20
    01:29:17.739 [ForkJoinPool-1-worker-1] calculate 8 -> 80
    01:29:18.750 [ForkJoinPool-1-worker-3] [처리 완료] [5, 6] -> sum: 110
    01:29:18.750 [ForkJoinPool-1-worker-2] [처리 완료] [3, 4] -> sum: 70
    01:29:18.750 [ForkJoinPool-1-worker-1] [처리 완료] [7, 8] -> sum: 150
    01:29:18.750 [ForkJoinPool-1-worker-4] [처리 완료] [1, 2] -> sum: 30
    01:29:18.758 [ForkJoinPool-1-worker-1] LEFT[110] / RIGHT[150] -> sum: 260
    01:29:18.758 [ForkJoinPool-1-worker-2] LEFT[30] / RIGHT[70] -> sum: 100
    01:29:18.759 [ForkJoinPool-1-worker-1] LEFT[100] / RIGHT[260] -> sum: 360
    01:29:18.766 [     main] time: 2067ms, sum: 360
    01:29:18.767 [     main] pool: java.util.concurrent.ForkJoinPool@57baeedf[Terminated, parallelism = 10, size = 0, active = 0, running = 0, steals = 4, tasks = 0, submissions = 0]
    */
}
