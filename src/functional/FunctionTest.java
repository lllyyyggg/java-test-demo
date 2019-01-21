package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {

        Function<String, String> emphasize = FunctionTest::emphasize;
        Function<String, String> uppercase = FunctionTest::upperCase;
        Function<String, String> decorateString = FunctionTest::decorateS;
        Function<String, String[]> split = FunctionTest::split;
        Consumer<Object> printAnything = System.out::println;

        Function<String, String[]> emphasize_uppercase_split = compose(split, uppercase, emphasize);
        printAnything.accept(Arrays.toString(emphasize_uppercase_split.apply("HELLO")));

        // 这种以匿名内部类模拟的方法可以用于List的map方法作为参数。
        List<String> list = getList("Hello", "World");
        list.stream().map(emphasize).map(uppercase).forEach(printAnything);

        // 也可以针对单个字符串进行
        String s = "Hello";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            compose(decorateString, emphasize, uppercase).apply(s);
            compose(uppercase, emphasize).apply(s);
            //printAnything.accept(compose(decorateString, emphasize, uppercase).apply(s));
            //printAnything.accept(compose(uppercase, emphasize).apply(s));
        }
        printAnything.accept(System.currentTimeMillis() - start + "ms");

        // 虽然有函数式编程更加方便，但是会比较慢
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            decorateS(emphasize(s.toUpperCase()));
            upperCase(emphasize(s));
            //printAnything.accept(decorateS(emphasize(s.toUpperCase())));
            //printAnything.accept(upperCase(emphasize(s)));
        }
        printAnything.accept(System.currentTimeMillis() - start + "ms");

    }

    private static <T, R> Function<T, R> compose(Function... functions) {
        //Arrays.stream(functions).reduce()
        int length = functions.length;
        Function next = functions[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            Function curr = functions[i];
            next = curr.compose(next);
        }
        return next;
    }

    private static String[] split(String s) {
        return s.split("");
    }

    public static <T> List<T> getList(T... ts) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(ts));
        return list;
    }

    private static String emphasize(String s) {
        return s + "!";
    }

    private static String upperCase(String s) {
        return s.toUpperCase();
    }

    private static String decorateS(String s) {
        return "This is the upper and emphasized string : " + s;
    }
}
