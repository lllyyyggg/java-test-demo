package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphorTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        Thread t1 = new Thread(new Job(semaphore));
        Thread t2 = new Thread(new Job(semaphore));
        Thread t3 = new Thread(new Job(semaphore));
        Thread t4 = new Thread(new Job(semaphore));
        Thread t5 = new Thread(new Job(semaphore));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Job implements Runnable {
        private final Semaphore semaphore;

        public Job(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Hello, This is " + Thread.currentThread().getId());
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                // do something
            } finally {
                semaphore.release();
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                //do something
            }
            try {
                semaphore.acquire();
                System.out.println("Hello Again, This is " + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                // do something
            } finally {
                semaphore.release();
            }
        }
    }
}
