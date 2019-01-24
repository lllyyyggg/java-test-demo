package pattern.create;

import java.util.Optional;

public class FactoryTest {

    private static class Factory {
        public static <T> T create(Class<T> clazz) throws IllegalAccessException, InstantiationException {
            return Optional.of(clazz).get().newInstance();
        }
    }

    static class Animal {
    }

    static class Dog extends Animal {
    }

    static class Cat extends Animal {
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Animal dog = Factory.create(Dog.class);
        Animal cat = Factory.create(Cat.class);
        System.out.println(dog.getClass());
        System.out.println(cat.getClass());
    }
}
