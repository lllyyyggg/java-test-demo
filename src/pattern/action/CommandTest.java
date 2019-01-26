package pattern.action;

import java.util.ArrayList;
import java.util.List;

public class CommandTest {
    static class Stock {
        private String name;
        private int quantity;

        public Stock(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    interface Order {
        void execute();
    }

    static class BuyStockCommand implements Order {
        private final Stock stock;

        public BuyStockCommand(Stock stock) {
            this.stock = stock;
        }

        @Override
        public void execute() {
            System.out.println("Sell --- Stock [" + stock.getName() + "], Quantity : [" + stock.getQuantity() + "]");
        }
    }

    static class SellStockCommand implements Order {
        private final Stock stock;

        public SellStockCommand(Stock stock) {
            this.stock = stock;
        }

        @Override
        public void execute() {
            System.out.println("Buy --- Stock [" + stock.getName() + "], Quantity : [" + stock.getQuantity() + "]");
        }
    }

    static class Broker {
        private final List<Order> orders = new ArrayList<>();

        public void takeOrder(Order order) {
            orders.add(order);
        }
        public void executeOrders() {
            if(orders.size() == 0) {
                System.out.println("There is no order to be executed !!!");
                return;
            }
            for (Order order : orders) {
                order.execute();
            }
            orders.clear();
        }
    }

    public static void main(String[] args) {
        Stock stock = new Stock("ALIBABA", 999);
        Broker broker = new Broker();
        broker.takeOrder(new BuyStockCommand(stock));
        broker.takeOrder(new BuyStockCommand(stock));
        broker.takeOrder(new SellStockCommand(stock));
        broker.executeOrders();
    }
}
