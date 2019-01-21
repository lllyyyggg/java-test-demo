package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        //AtomicInteger n = new AtomicInteger(1);
        ThreadTest t = new ThreadTest();
        MyNumber n = new MyNumber(1);
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                n.getAnIncrement();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(n.get());

    }

    static class MyNumber {
        private volatile int value;

        public MyNumber(int value) {
            this.value = value;
        }

        public int get() {
            return value;
        }

        public void getAnIncrement() {
            synchronized (this) {
                System.out.println(value++);
            }
        }
    }
}


