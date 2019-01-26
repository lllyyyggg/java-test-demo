package pattern.action;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    static class Subject {
        private final List<Observer> observers = new ArrayList<>();
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyObservers();
        }

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    static abstract class Observer {
        protected Subject subject;

        public Observer(Subject subject) {
            this.subject = subject;
            subject.attach(this);
        }

        public abstract void update();
    }

    static class BinaryObserver extends Observer {
        public BinaryObserver(Subject subject) {
            super(subject);
        }

        @Override
        public void update() {
            System.out.println("Subject changed , Binary String : " + Integer.toBinaryString(subject.getState()));
        }
    }

    static class OctalObserver extends Observer {
        public OctalObserver(Subject subject) {
            super(subject);
        }

        @Override
        public void update() {
            System.out.println("Subject changed , Octal String : " + Integer.toOctalString(subject.getState()));
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        subject.setState(15);
        subject.setState(20);
    }
}
