package pattern.create;

public class AbstractFactoryTest {
    static class Phone {
    }

    static class HuaweiPhone extends Phone {
    }

    static class Iphone extends Phone {
    }

    static class Pad {
    }

    static class HuaweiPad extends Pad {
    }

    static class Ipad extends Pad {
    }

    static abstract class DigitalFactory {
        abstract Phone createPhone();

        abstract Pad createPad();
    }

    static class HuaweiFactory extends DigitalFactory {
        @Override
        Phone createPhone() {
            return new HuaweiPhone();
        }

        @Override
        Pad createPad() {
            return new HuaweiPad();
        }
    }
    static class AppleFactory extends DigitalFactory {

        @Override
        Phone createPhone() {
            return new Iphone();
        }

        @Override
        Pad createPad() {
            return new Ipad();
        }
    }

    public static void main(String[] args) {
        DigitalFactory digitalFactory = new HuaweiFactory();
        //DigitalFactory digitalFactory = new AppleFactory();
        Phone phone= digitalFactory.createPhone();
        Pad pad = digitalFactory.createPad();
        System.out.println(phone);
        System.out.println(pad);
    }
}
