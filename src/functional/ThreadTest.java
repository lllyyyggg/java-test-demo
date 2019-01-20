package functional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(50);
        MyNumber mn = new MyNumber(1);
        CountDownLatch cdl = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            service.execute(new Increment(mn, cdl));
        }
        cdl.await();
        service.shutdown();
        System.out.println(mn);
    }

    private static class MyNumber {
        private int value;

        public MyNumber(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public  int increment() {
            return value++;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }

    private static class Increment implements Runnable {
        private MyNumber mn;
        private CountDownLatch cdl;

        public Increment(MyNumber mn, CountDownLatch cdl) {
            this.mn = mn;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("use number : " + mn.increment());
            cdl.countDown();
        }
    }
}




