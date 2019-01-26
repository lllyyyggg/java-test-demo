package pattern.action;

public class VistorTest {

    interface ComputerPart {
        void accept(ComputerPartVisitor visitor);
    }

    static class Mouse implements ComputerPart {
        @Override
        public void accept(ComputerPartVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class Keyboard implements ComputerPart {
        @Override
        public void accept(ComputerPartVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class Monitor implements ComputerPart {
        @Override
        public void accept(ComputerPartVisitor visitor) {
            visitor.visit(this);
        }
    }

    static class Computer implements ComputerPart {
        ComputerPart[] parts;

        public Computer() {
            parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
        }

        @Override
        public void accept(ComputerPartVisitor visitor) {
            for (int i = 0; i < parts.length; i++) {
                parts[i].accept(visitor);
            }
            visitor.visit(this);
        }
    }

    interface ComputerPartVisitor {
        void visit(Computer computer);

        void visit(Monitor monitor);

        void visit(Keyboard keyboard);

        void visit(Mouse mouse);
    }

    static class ComputerPartDisplayVisitor implements ComputerPartVisitor {
        @Override
        public void visit(Computer computer) {
            System.out.println("Displaying computer");
        }

        @Override
        public void visit(Monitor monitor) {
            System.out.println("Displaying monitor");
        }

        @Override
        public void visit(Keyboard keyboard) {
            System.out.println("Displaying keyboard");
        }

        @Override
        public void visit(Mouse mouse) {
            System.out.println("Displaying mouse");
        }
    }

    public static void main(String[] args) {
        ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();
        System.out.println("---keyboard---");
        ComputerPart keyboard = new Keyboard();
        keyboard.accept(visitor);
        System.out.println("---computer---");
        ComputerPart computer = new Computer();
        computer.accept(visitor);
    }
}
