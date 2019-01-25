package pattern.structure;

public class ProxyTest {

    interface PlayGameAPI {
        void play();
        void upgrade();
    }

    static class RealPlayer implements PlayGameAPI {
        private String username;
        private String password;

        public RealPlayer(String username, String password) {
            this.username = username;
            this.password = password;
        }

        private void login() {
            System.out.println("Login with username : " + username + " and password : " + password);
        }

        @Override
        public void play() {
            System.out.println("Play");
        }

        @Override
        public void upgrade() {
            System.out.println("Upgrade");
        }

        private void logout() {
            System.out.println(username + " logout");
        }
    }

    static class PlayerProxy implements PlayGameAPI {
        private RealPlayer realPlayer;

        public void setUp(String username, String password) {
            realPlayer = new RealPlayer(username, password);
            realPlayer.login();
        }

        @Override
        public void play() {
            if (realPlayer == null) {
                System.out.println("please provide your username and password");
            }
            realPlayer.play();
        }

        @Override
        public void upgrade() {
            for (int i = 0; i < 10; i++) {
                realPlayer.upgrade();
            }
            realPlayer.logout();
        }
    }

    public static void main(String[] args) {
        PlayGameAPI proxy = new PlayerProxy();
        ((PlayerProxy) proxy).setUp("lanyage", "123");
        proxy.play();
        proxy.upgrade();
    }
}
