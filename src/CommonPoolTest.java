import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonPoolTest {

    public static void main(String[] args) {
        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        long start = System.nanoTime();
        List<CompletableFuture<Void>> futures = IntStream.range(0, 100)
            .mapToObj(i -> CompletableFuture.runAsync(CommonPoolTest::blockingOperation))
            .collect(Collectors.toList());

       // CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        futures
            .stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
        System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).getSeconds() + " sec");
    }

    private static void blockingOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
