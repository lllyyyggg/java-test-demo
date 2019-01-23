package functional;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(1, 2));
    }
}
