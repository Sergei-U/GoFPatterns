/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Decorator {
    /**
     * Декоратор позволяет динамически добавлять объектам новую функциональность,
     * оборачивая их в полезные «обёртки».
     */

    interface Notifier {
        void sendData(String s);
    }

    //Базовый нотификатор
    static class BaseNotifier implements Notifier {
        BaseNotifier() {
            //Базовый конструктор
        }

        @Override
        public void sendData(String s) {
            System.out.println("Base notifier :" + s);
        }
    }

    //Родитель всех декораторов
    static class BaseDecorator implements Notifier {
        Notifier wrapper;

        BaseDecorator(Notifier notifier) {
            this.wrapper = notifier;
        }

        @Override
        public void sendData(String s) {
            wrapper.sendData(s);
        }
    }

    //Улучшенный декоратор, добавляет что-то своё

    static class AdvancedDecorator extends BaseDecorator {
        AdvancedDecorator(Notifier notifier) {
            super(notifier);
        }

        public void telegraphSend(String s) {
            System.out.println("Метод отправки нотификаций в Телеграф");
        }
    }
    // Декорировать можно не только базовые компоненты, но и уже
    // обёрнутые объекты.


    public static void main(String[] args) {
        BaseNotifier baseNotifier = new BaseNotifier();
        AdvancedDecorator advancedDecorator = new AdvancedDecorator(baseNotifier);
        advancedDecorator.telegraphSend("dff");

        BaseDecorator baseDecorator = new BaseDecorator(baseNotifier);
        baseDecorator.sendData("ff");
    }

}
