package override;

import java.util.function.Consumer;

public class OverrideTest {

    private static class Person {
        public String getClassName() {
            return this.getClass().getSimpleName();
        }
    }

    private static class Student extends Person {
        @Override
        public String getClassName() {
            return this.getClass().getSimpleName();
        }
    }

    public static void main(String[] args) {
        Consumer<Object> consumer = System.out::println;
        Person p = new Person();
        Person p2 = new Student();
        Student s = new Student();
        consumer.accept(p.getClassName());
        consumer.accept(p2.getClassName());
        consumer.accept(s.getClassName());
        //output:
        //Person
        //Student
        //Student
    }
}
