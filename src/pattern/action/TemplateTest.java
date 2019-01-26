package pattern.action;

public class TemplateTest {
    static abstract class AbstractGamePlayAPI {
        public abstract void initialize();

        public abstract void startPlay();

        public abstract void stopPlay();

        public void play() {
            initialize();
            startPlay();
            stopPlay();
        }
    }

    static class PlayCricket extends AbstractGamePlayAPI {
        @Override
        public void initialize() {
            System.out.println("Cricket initialized");
        }

        @Override
        public void startPlay() {
            System.out.println("Start playing Cricket");
        }

        @Override
        public void stopPlay() {
            System.out.println("Stop playing Cricket");
        }
    }

    static class PlayFootball extends AbstractGamePlayAPI {
        @Override
        public void initialize() {
            System.out.println("Football initialized");
        }

        @Override
        public void startPlay() {
            System.out.println("Start playing Football");
        }

        @Override
        public void stopPlay() {
            System.out.println("Stop playing Football");
        }
    }

    public static void main(String[] args) {
        AbstractGamePlayAPI playCricket = new PlayCricket();
        AbstractGamePlayAPI playFootball = new PlayFootball();
        playCricket.play();
        playFootball.play();
    }
}
