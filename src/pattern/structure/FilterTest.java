package pattern.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterTest {
    interface Cretiria<T> {
        List<T> meetCretiria(List<T> ts);
    }

    static class Person {
        private String name;
        private String sex;
        private int age;

        public Person(String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class MaleCretiria implements Cretiria<Person> {
        @Override
        public List<Person> meetCretiria(List<Person> people) {
            Iterator<Person> it = people.iterator();
            while (it.hasNext()) {
                if (!it.next().getSex().equalsIgnoreCase("male")) {
                    it.remove();
                }
            }
            return people;
        }
    }

    static class AdultCretiria implements Cretiria<Person> {
        @Override
        public List<Person> meetCretiria(List<Person> people) {
            Iterator<Person> it = people.iterator();
            while (it.hasNext()) {
                if (!(it.next().getAge() >= 18)) {
                    it.remove();
                }
            }
            return people;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", "Male", 18));
        personList.add(new Person("Jerry", "Male", 17));
        personList.add(new Person("Alice", "Female", 17));

        Cretiria adultCretiria = new AdultCretiria();
        Cretiria maleCretiria = new MaleCretiria();

        System.out.println(maleCretiria.meetCretiria(personList));
        System.out.println(adultCretiria.meetCretiria(personList));
    }
}
