package pattern.create;

public class PrototypeTest {
    private static class Prototype implements Cloneable {
        private int id;
        private Prototype next;

        public Prototype(int id) {
            this.id = id;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Prototype copy = (Prototype) super.clone();
            if (next != null) {
                copy.setNext((Prototype) next.clone());
            }
            return copy;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Prototype getNext() {
            return next;
        }

        public void setNext(Prototype next) {
            this.next = next;
        }

        public Prototype copy() throws CloneNotSupportedException {
            return Prototype.class.cast(clone());
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype(1);
        Prototype p2 = new Prototype(2);
        p1.setNext(p2);
        System.out.println(p1 + " : " + p1.getId() + " : " + p1.getNext().getId());
        System.out.println(p2 + " : " + p2.getId() + " : " + p2.getNext());

        Prototype p3 = p1.copy();
        Prototype p4 = p3.getNext();
        System.out.println(p3 + " : " + p3.getId() + " : " + p3.getNext().getId());
        System.out.println(p4 + " : " + p4.getId() + " : " + p4.getNext());
    }
}
