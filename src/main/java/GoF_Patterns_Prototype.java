import java.util.ArrayList;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Prototype {
    abstract static class WObject {
        int x;
        int y;
        double z;

        WObject() {
            x = 0;
            y = 0;
            z = 0.15;
        }

        WObject(WObject object) {
            this.x = object.x;
            this.y = object.y;
            this.z = object.z;
        }

        public abstract Object clone();

    }

    static class RealObjectOne extends WObject {
        int weight;

        RealObjectOne(RealObjectOne realObjectOne) {
            super(realObjectOne);
            this.weight = realObjectOne.weight;
        }

        public RealObjectOne() {

        }

        @Override
        public Object clone() {
            return new RealObjectOne(this);
        }
    }

    static class RealObjectTwo extends WObject {
        int weight;
        int anotherint;

        RealObjectTwo(RealObjectTwo realObjectTwo) {
            super(realObjectTwo);
            this.weight = realObjectTwo.weight;
            this.anotherint = realObjectTwo.anotherint;
            ;
        }

        public RealObjectTwo() {

        }


        @Override
        public Object clone() {
            return new RealObjectTwo(this);
        }
    }

    public static void main(String[] args) {

        //Создаём наши два объекта
        RealObjectOne realObjectOne = new RealObjectOne();
        RealObjectTwo realObjecTwo = new RealObjectTwo();
        ArrayList list = new ArrayList();
        list.add(realObjectOne);
        list.add(realObjecTwo);

        //Обекты для клонирования
        ArrayList listTwo = new ArrayList();

        listTwo.add(realObjectOne.clone());
        listTwo.add(realObjecTwo.clone());
    }
}
