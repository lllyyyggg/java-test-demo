package serializing;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Person partner;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person partner) {
        this.name = name;
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", partner=" + partner +
                '}';
    }
}
