package pattern.action;

public class ChainTest {
    static abstract class AbstractLogger {
        public static int DEBUG = 1;
        public static int INFO = 2;
        public static int ERROR = 3;
        protected int level;
        private AbstractLogger next;

        public AbstractLogger(int level) {
            this.level = level;
        }

        public void setNext(AbstractLogger next) {
            this.next = next;
        }

        public void logMessage(int level, String message) {
            if (this.level == level) {
                log(message);
            } else {
                next.logMessage(level, message);
            }
        }

        protected abstract void log(String message);
    }

    static class InfoLogger extends AbstractLogger {

        public InfoLogger(int level) {
            super(level);
        }

        @Override
        protected void log(String message) {
            System.out.println("This is an information : " + message);
        }
    }

    static class DebugLogger extends AbstractLogger {
        public DebugLogger(int level) {
            super(level);
        }

        @Override
        protected void log(String message) {
            System.out.println("This is an debug : " + message);
        }
    }

    static class ErrorLogger extends AbstractLogger {
        public ErrorLogger(int level) {
            super(level);
        }

        @Override
        protected void log(String message) {
            System.out.println("This is an error : " + message);
        }
    }
    static class End extends AbstractLogger{
        public End(int level) {
            super(level);
        }

        @Override
        protected void log(String message) {
            throw new RuntimeException("This is the end");
        }
    }
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        debugLogger.setNext(infoLogger);
        infoLogger.setNext(errorLogger);
        return debugLogger;
    }

    public static void main(String[] args) {
        AbstractLogger chain = getChainOfLoggers();
        chain.logMessage(3, "Hello World");
    }
}
