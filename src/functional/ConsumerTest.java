package functional;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<Integer> id = System.out::println;
        id.andThen(ConsumerTest::doubleX).accept(2);
    }
    private static void doubleX(Integer x) {
        System.out.println(x * 2);
    }
}
