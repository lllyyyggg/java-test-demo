package pattern.action;

import java.util.ArrayList;
import java.util.List;

public class MementoTest {
    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    static class Originator {
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Memento saveStateToMemento() {
            return new Memento(state);
        }

        public void getStateFromMemento(Memento memento) {
            state = memento.getState();
        }
    }

    static class CareTaker {
        private List<Memento> mementoList = new ArrayList<>();

        public void add(Memento memento) {
            mementoList.add(memento);
        }

        public Memento get(int index) {
            return mementoList.get(index);
        }
    }

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State : " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("Current State : " + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Current State : " + originator.getState());
    }
}
