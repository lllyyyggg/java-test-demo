package serializing;

import java.io.*;

/**
 * 对象的序列化
 */
public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
        Person person = new Person("lanyage");
        Person person2 = new Person("daimengxiao");
        person.setPartner(person2);
        oos.writeObject(person);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
        Object personObj = ois.readObject();
        if (personObj instanceof Person) {
            Person p = Person.class.cast(personObj);
            System.out.println(p);
        }
    }
}
