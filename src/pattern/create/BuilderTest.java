package pattern.create;

import java.util.function.Consumer;

public class BuilderTest {
    private static class Person {
        private int id;
        private String name;
        private String sex;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public static class PersonBuilder {
            private int id;
            private String name;
            private String sex;

            public PersonBuilder id(int id) {
                this.id = id;
                return this;
            }

            public PersonBuilder name(String name) {
                this.name = name;
                return this;
            }

            public PersonBuilder sex(String sex) {
                this.sex = sex;
                return this;
            }

            public Person build() {
                Person p = new Person();
                p.setId(id);
                p.setName(name);
                p.setSex(sex);
                return p;
            }
        }
    }

    public static void main(String[] args) {
        Person person = Person.builder()
                .id(1)
                .name("lanyage")
                .sex("male")
                .build();
        Consumer<Object> consumer = System.out::println;
        consumer.accept(person);
    }
}
