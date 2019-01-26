package pattern.action;

public class StrategyTest {

    interface Strategy {
        void operate(int n, int m);
    }

    static class AddOperator implements Strategy {
        @Override
        public void operate(int n, int m) {
            System.out.println("Add Result : " + (n + m));
        }
    }

    static class MultiplyOperator implements Strategy {
        @Override
        public void operate(int n, int m) {
            System.out.println("Multiply Result : " + (n * m));
        }
    }

    public static void main(String[] args) {
        Strategy add = new AddOperator();
        add.operate(2, 3);
        Strategy multi = new MultiplyOperator();
        multi.operate(2, 3);
    }
}
