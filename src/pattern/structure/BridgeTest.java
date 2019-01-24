package pattern.structure;

// 例(红色圆圈， 灰色圆圈)，不同的形状有不同的行为，那么行为的接口就是桥，形状就是抽象类，抽象类持有桥的引用
// 如果我突然想实现红色的正方形、灰色的正方形就可以在抽象类和接口两边分别添加代码了，符合开闭原则

public class BridgeTest {

    static abstract class Shape {
        protected DrawColoredShapeAPI drawShape;

        protected Shape(DrawColoredShapeAPI drawShape) {
            this.drawShape = drawShape;
        }

        abstract void draw();
    }

    static class Circle extends Shape {

        protected Circle(DrawColoredShapeAPI drawShape) {
            super(drawShape);
        }

        @Override
        void draw() {
            this.drawShape.drawShape();
        }
    }

    static class Square extends Shape {
        protected Square(DrawColoredShapeAPI drawShape) {
            super(drawShape);
        }

        @Override
        void draw() {
            drawShape.drawShape();
        }
    }


    interface DrawColoredShapeAPI {
        void drawShape();      // do specific operations
    }

    static class DrawRedCircle implements DrawColoredShapeAPI {
        @Override
        public void drawShape() {
            System.out.println("Draw Circle : { color :  Red  }");
        }
    }

    static class DrawGreyCircle implements DrawColoredShapeAPI {
        @Override
        public void drawShape() {
            System.out.println("Draw Circle : { color :  Grey  }");
        }
    }

    static class DrawGreySquare implements DrawColoredShapeAPI {
        @Override
        public void drawShape() {
            System.out.println("Draw Square: { color : Grey }");
        }
    }

    static class DrawRedSquare implements DrawColoredShapeAPI {
        @Override
        public void drawShape() {
            System.out.println("Draw Square: { color: Red }");
        }
    }

    public static void main(String[] args) {
        Shape greyCircle = new Circle(new DrawGreyCircle());
        Shape redCircle = new Circle(new DrawRedCircle());
        greyCircle.draw();
        redCircle.draw();

        Shape greySquare = new Square(new DrawGreySquare());
        Shape redSquare = new Square(new DrawRedSquare());
        greySquare.draw();
        redSquare.draw();
    }
}
