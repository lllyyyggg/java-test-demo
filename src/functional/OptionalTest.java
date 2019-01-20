package functional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        // 解决空值判断
        //Optional<String> opt = Optional.ofNullable(null);
        //opt.ifPresent(System.out::println);

        // 设置默认值
        //Optional<String> opt = Optional.ofNullable(null);
        //System.out.println(opt.orElse("test"));

        // 变量为空抛出异常
        Optional<String> o = Optional.ofNullable("test");
        System.out.println(o.orElseThrow(OptionalTest::throwRuntimeException));
    }

    private static RuntimeException throwRuntimeException() {
        return new RuntimeException("参数为空");
    }
}
