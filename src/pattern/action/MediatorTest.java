package pattern.action;

import java.util.Date;

public class MediatorTest {

    static class ChatRoom {
        public static void showMessage(User user, String message) {
            System.out.println(new Date() + " : [ username = " + user.getName() + ", message =  " + message + " ]");
        }
    }

    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void sendMessage(String message) {
            ChatRoom.showMessage(this, message);
        }
    }

    public static void main(String[] args) {
        User john = new User("John");
        User alice = new User("Alice");
        john.sendMessage("Hello, Alice!");
        alice.sendMessage("Hi, John!");
    }
}
