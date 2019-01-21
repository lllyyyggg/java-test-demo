package thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeTest {
    private static Unsafe getInstance() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(Unsafe.class);
    }

    // 很多线程相同时修改n的值, 但是最终只有一个成功。
    // 其原理就是对相同的变量首先读一次，进行计算，然后再去和内存中的值进行比较，如果被修改了，那么就重新读取内存中的值进行计算。
    // 否则，直接用新计算的值替换原有的值。
    // 比如,读取 1, 计算2, 然后比较内存中的值是不是还是1, 是1那么就用2进行替换。
    // 否则, 再次读取新值k, 然后计算得k + 1, 比较内存中的值是否发生变化，如此往复直到成功
    // 之所以是k是因为再一次读取的时候，已经有很多线程对其进行了自增
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyNumber n = new MyNumber(1);
        Unsafe unsafe = getInstance();
        long valueOffSet = unsafe.objectFieldOffset(MyNumber.class.getDeclaredField("value"));
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            service.execute(() -> System.out.println(unsafe.compareAndSwapInt(n, valueOffSet, 1, 2) + " " + n.get()));
        }
        service.shutdown();
    }

    static class MyNumber {
        private volatile int value;

        public MyNumber(int value) {
            this.value = value;
        }

        public int get() {
            return value;
        }
    }
}
