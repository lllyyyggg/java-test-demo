package pattern;

import java.util.function.Consumer;

public class BuilderTest {
    public static void main(String[] args) {
        Person person = Person.builder()
                .id(1)
                .name("lanyage")
                .sex("male")
                .build();
        Consumer<Object> consumer = System.out::println;
        consumer.accept(person);
    }
}
