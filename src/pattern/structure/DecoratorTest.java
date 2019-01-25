package pattern.structure;

public class DecoratorTest {

    static abstract class Gun {
        public abstract void fire();
    }

    static class CommonGun extends Gun {
        @Override
        public void fire() {
            System.out.println("fire !!!");
        }
    }

    static class CommonGunRiffleDecorator extends Gun {
        private Gun commonGun;

        public CommonGunRiffleDecorator(Gun commonGun) {
            this.commonGun = commonGun;
        }

        @Override
        public void fire() {
            loadBullets();
            commonGun.fire();
            causeHugeDamage();
        }

        private void loadBullets() {
            System.out.println("load bullets !!!");
        }

        private void causeHugeDamage() {
            System.out.println("cause huge damage !!! boom boom boom !!!");
        }
    }

    public static void main(String[] args) {
        System.out.println("common gun fire");
        Gun commonGun = new CommonGun();
        commonGun.fire();
        System.out.println("\nriffle gun fire");
        Gun riffleGun = new CommonGunRiffleDecorator(commonGun);
        riffleGun.fire();
    }
}
