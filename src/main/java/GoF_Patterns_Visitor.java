/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Visitor {

    /**
     * Паттерн посетитель позволяет добавлять в программу новые операции,
     * не изменяя классы объектов, над которыми эти операции могут выполняться.
     * Он предлагает размещать дополнительные новые поведения объектов в отдельном классе.
     * Также объекты не будут выполнять этот метод самостоятельно,
     * а вместо этого предполагается передавать их.
     */

    //какая-то сложная невнятная иерархия объектов
    interface Dott{
        void run();
        void test(int x);
        void doDott(Visitor visitor);

    }
    static class Point implements Dott {

        @Override
        public void run() {
            System.out.println("run point");
        }

        @Override
        public void test(int x) {
            System.out.println("run point x"+x);
        }

        @Override
        public void doDott(Visitor visitor) {
            visitor.runPoint(this);
        }
    }

    static class OtherObject implements Dott{

        @Override
        public void run() {
            System.out.println("run OtherObject");
        }

        @Override
        public void test(int x) {
            System.out.println("run OtherObject "+ x);
        }

        @Override
        public void doDott(Visitor visitor) {
            visitor.runOtherObject(this);
        }
    }

    //интерефейс посетителя
    //По сути он позволяет добавлять новые данные, не изменяя старых методов
    interface Visitor{
        void runPoint(Point point);
        void runOtherObject(OtherObject otherObject);
    }

    // Конкретный посетитель обычно реализует одну операцию для всей
    // иерархии элементов.Каждая новая операция – это новый посетитель.
    // Посетителя выгодно применять, когда новые элементы
    // добавляются очень редко, а новые операции – часто.

    static class AdvancedVisitor implements Visitor{

        @Override
        public void runPoint(Point point) {
            System.out.println("sff");
        }

        @Override
        public void runOtherObject(OtherObject otherObject) {
            System.out.println("ssdfsdff");
        }
    }

    public static void main(String[] args) {
        AdvancedVisitor advancedVisitor = new AdvancedVisitor();

        Point point = new Point();
        OtherObject otherObject = new OtherObject();

        point.doDott(advancedVisitor);
        point.run();
        point.test(12);

        otherObject.doDott(advancedVisitor);
        otherObject.run();
        otherObject.test(15);
    }
}
