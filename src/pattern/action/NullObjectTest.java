package pattern.action;

import java.util.HashMap;
import java.util.Map;

public class NullObjectTest {

    static abstract class AbstractPerson {
        protected String name;

        abstract String getName();

        abstract boolean isNull();
    }

    static class Person extends AbstractPerson {
        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        boolean isNull() {
            return false;
        }
    }

    static class NullPerson extends AbstractPerson {
        public NullPerson() {
        }

        @Override
        String getName() {
            // do something special
            throw new RuntimeException("该用户不存在");
        }

        @Override
        boolean isNull() {
            return true;
        }
    }

    static class PersonFactory {
        private static final Map<String, Person> personMap = new HashMap<>();
        private static final NullPerson nullPerson = new NullPerson();

        static {
            Person tom = new Person("Tom");
            Person bob = new Person("Bob");
            personMap.put(tom.getName(), tom);
            personMap.put(bob.getName(), bob);
        }

        public static AbstractPerson get(String name) {
            if (personMap.containsKey(name)) {
                return personMap.get(name);
            } else {
                return nullPerson;
            }
        }
    }

    public static void main(String[] args) {
        AbstractPerson tom = PersonFactory.get("Tom");
        System.out.println(tom.getName() + " " + tom.isNull());
        AbstractPerson bob = PersonFactory.get("Bob");
        System.out.println(bob.getName() + " " + bob.isNull());
        AbstractPerson lucy = PersonFactory.get("Lucy");
        System.out.println(lucy.getName() + " " + lucy.isNull());
    }
}
