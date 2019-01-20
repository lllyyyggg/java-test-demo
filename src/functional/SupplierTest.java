package functional;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) throws Throwable {
        Supplier<Exception> supplier = () -> newRuntimeException("RuntimeException");
        System.out.println(supplier.get());
        System.out.println(supplier.get().getMessage());
        Student student = getStudent("lanyage");
        System.out.println(student);
        System.out.println(student.name);
    }

    private static Student getStudent(String name) {
        return ((Supplier<Student>)(() -> new Student(name))).get();
    }


    private static Exception newRuntimeException(String msg) {
        return new RuntimeException("Runtime Exception!!!");
    }
    private static class Student {
        private String name;
        public Student(String name) {
            this.name = name;
        }
    }
}
