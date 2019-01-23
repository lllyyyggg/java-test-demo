package functional;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
       BiConsumer<String, String> biConsumer = (s, s2) -> System.out.println(s + s2);
       biConsumer.accept("hello", " world");
    }
}
