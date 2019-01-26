package pattern.action;

public class StateTest {
    interface AtomStateAPI {
        void getState();    // different kind of atom acts differently
    }

    static class ColdAtom implements AtomStateAPI {
        @Override
        public void getState() {
            System.out.println("Cold atom is stable !!!");
        }
    }

    static class HotAtom implements AtomStateAPI {
        @Override
        public void getState() {
            System.out.println("Hot atom is not stable !!! about to blow !!!");
        }
    }

    public static void main(String[] args) {
        AtomStateAPI coldAtom = new ColdAtom();
        AtomStateAPI hotAtom = new HotAtom();
        coldAtom.getState();
        hotAtom.getState();
    }
}
