/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Fabric {

    //Паттерн применим только когда есть иерархия продуктов
    interface Delivery {
        void supply();
    }

    //Человек доставляет
    static class Human implements Delivery {
        @Override
        public void supply() {
            System.out.println("Human supply");
        }
    }

    //Или велосипед
    static class Bike implements Delivery {
        @Override
        public void supply() {
            System.out.println("Bike supply");
        }
    }

    //Абстрактный класс доставки
    static abstract class MakeDelivery {
        void runDelivery() {
            Delivery delivery = createDelivery();
            delivery.supply();
        }

        //Абстрактный фабричный метод доставки
        abstract Delivery createDelivery();
    }

    // Конкретные фабрики переопределяют фабричный метод и
    // возвращают из него собственные продукты.
    static class BikeSupp extends MakeDelivery {
        Delivery createDelivery() {
            return new Bike();
        }
    }

    static class HumanSupp extends MakeDelivery {
        Delivery createDelivery() {
            return new Human();
        }
    }

    public static void main(String[] args) {
        MakeDelivery delivery;
        //Создаем доставку в зависимости от условий
        if (true) {
            delivery = new BikeSupp();
        } else {
            delivery = new HumanSupp();
        }
        //остальной клиентский код работает с фабриками и
        //продуктами только через общий интерфейс, для него
        //будет не важно, какая фабрика была создана изначально
        delivery.runDelivery();
    }
}

