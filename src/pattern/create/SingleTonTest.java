package pattern.create;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTonTest {

    private static class SingleTon implements Serializable {
        private static SingleTon INSTANCE = null;

        private SingleTon() {
        }

        public static SingleTon get() {
            if (null == INSTANCE) {
                synchronized (SingleTon.class) {
                    if (null == INSTANCE) {
                        INSTANCE = new SingleTon();
                    }
                }
            }
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            exe.execute(() -> System.out.println(SingleTon.get()));
        }
        exe.shutdown();
    }
}
