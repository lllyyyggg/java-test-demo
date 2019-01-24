package pattern.structure;

import java.util.HashMap;
import java.util.Map;

public class FlyweightTest {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        private int x;
        private int y;
        private String color;

        public Circle(String color) {
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public void draw() {
            System.out.println("Draw Circle, x = " + x + ", y = " + y + ", color = " + color);
        }
    }

    static class ShapeFactory {
        private static final Map<String, Circle> circleMap = new HashMap<>();

        public static Shape getCircle(String color) {
            Circle circle = circleMap.get(color);
            if (circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
                System.out.println("Creating circle of color : " + color);
            }
            return circle;
        }
    }

    static class FlyweightDemo {
        private static final String[] colors = new String[]{"Red", "Blue", "Yellow"};

        public static void main(String[] args) {
            for (int i = 0; i < 20; i++) {
                Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
                circle.setX(getRandomeX());
                circle.setX(getRandomeY());
                circle.draw();
            }
        }

        private static String getRandomColor() {
            return colors[(int) (Math.random() * 100) % colors.length];
        }

        private static int getRandomeX() {
            return (int) (Math.random() * 100);
        }

        private static int getRandomeY() {
            return (int) (Math.random() * 100);
        }
    }
}
