package pattern.action;

public class InterpreterTest {
    interface Expression {
        boolean interpreter(String context);
    }

    static class TerminalExpression implements Expression {
        private String data;

        public TerminalExpression(String data) {
            this.data = data;
        }

        @Override
        public boolean interpreter(String context) {
            return context.contains(data);
        }
    }

    static class OrExpression implements Expression {
        private Expression e1;
        private Expression e2;

        public OrExpression(Expression e1, Expression e2) {
            this.e1 = e1;
            this.e2 = e2;
        }

        @Override
        public boolean interpreter(String context) {
            return e1.interpreter(context) || e2.interpreter(context);
        }
    }

    static class AndExpression implements Expression {
        private Expression e1;
        private Expression e2;

        public AndExpression(Expression e1, Expression e2) {
            this.e1 = e1;
            this.e2 = e2;
        }

        @Override
        public boolean interpreter(String context) {
            return e1.interpreter(context) && e2.interpreter(context);
        }
    }

    private static Expression getMaleExpression(String[] names) {

        Expression e1 = new TerminalExpression(names[0]);
        Expression e2 = new TerminalExpression(names[1]);
        return new OrExpression(e1, e2);
    }

    private static Expression womanMarriedExpression(String name) {
        Expression e1 = new TerminalExpression(name);
        Expression e2 = new TerminalExpression("Married");
        return new AndExpression(e1, e2);
    }

    public static void main(String[] args) {
        Expression isMaleExpression = getMaleExpression(new String[]{"John", "Bob"});
        Expression womenMarriedExpression = womanMarriedExpression("Julia");

        System.out.println("Is John Male ? " + isMaleExpression.interpreter("John"));
        System.out.println("Is Julia Married ? " + womenMarriedExpression.interpreter("Married Alice"));
    }
}
