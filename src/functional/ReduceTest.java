package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args) {

        // 求和
        //Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        //Integer number = stream.reduce((integer, integer2) -> integer + integer2).orElseThrow(() -> new RuntimeException(""));
        //System.out.println(number);

        // 求最大值
        //Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        //Integer number = stream.reduce((i, i2) -> i > i2 ? i : i2).orElse(null);
        //System.out.println(number);

        // 求字符串相加
        //Stream<String> stream = Stream.of("lanyage", "my", "name", "is", "shufang");
        //String s = stream.reduce("hello", (accu, curr) -> new StringBuilder(accu).append(",").append(curr).toString());
        //System.out.println(s);
    }
}
