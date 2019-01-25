package pattern.structure;

public class FacadeTest {

    static class Caller {
        public void call(String telephone) {
            System.out.println("Call : " + telephone);
        }
    }

    static class Orderer {
        public void order(String food) {
            System.out.println("Order : " + food);
        }
    }

    static class Payer {
        public void pay(int check) {
            System.out.println("Pay : " + check);
        }
    }

    static class FoodOrderFacade {
        private Caller caller;
        private Orderer orderer;
        private Payer payer;

        public FoodOrderFacade() {
            caller = new Caller();
            orderer = new Orderer();
            payer = new Payer();
        }

        public void getFood(String telephone, String food, int check) {
            caller.call(telephone);
            orderer.order(food);
            payer.pay(check);
        }
    }

    public static void main(String[] args) {
        FoodOrderFacade delegate = new FoodOrderFacade();
        delegate.getFood("18673862995", "Hamburger", 60);
    }
}
