package functional;

import java.util.List;
import java.util.function.Predicate;

public class PredictTest {

    // Predict用在filter上
    public static void main(String[] args) {
        Predicate<Integer> biggerThanOne = x -> x > 1;
        //System.out.println(biggerThanOne.test(1));

        List<Integer> list = FunctionTest.getList(1, 2, 3, 4, 5);
        //list.stream().filter(biggerThanOne).forEach(System.out::println);

        List<String> list2 = FunctionTest.getList("hello", "world");
        //list2.stream().flatMap(s -> Stream.of(s.split(""))).forEach(System.out::println);
    }

}
