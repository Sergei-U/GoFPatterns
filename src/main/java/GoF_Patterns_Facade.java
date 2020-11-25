import java.util.Random;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Facade {

    /**
     * Фасад — это структурный паттерн проектирования,
     * который предоставляет простой интерфейс к сложной системе классов, библиотеке или фреймворку.
     */

    static class Point extends Random {
        double x, y;

        Point() {
            this.x = this.nextLong();
            this.y = this.nextFloat();
        }
    }

    //Очень большой класс с множеством всего
    static class Goggle {
        //Та самая функция, что нам нужна
        double getDistance(Point curPos, Point objPos, String token) {
            token = token + token;
            return Math.sqrt((curPos.y - objPos.y) * (curPos.y - objPos.y) + (curPos.x - objPos.x) * (curPos.x - objPos.x));
        }
    }

    //Ещё один важный класс
    static class GoggleExt {
        String run() {
            System.out.println("Метод для подключения фреймворка");
            return "token-string";
        }

    }

    //И ещё сколько-то
    class Goggle1 {
    }

    class Goggle2 {
    }

    class Goggle3 {
    }

    class Goggle4 {
    }

    //Создаем наш класс-фасад
    static class Distance {
        double mathway(Point start, Point end) {
            return new Goggle().getDistance(start, end, new GoggleExt().run());
        }
    }


    public static void main(String[] args) {
        Distance distance = new Distance();
        System.out.println(distance.mathway(new Point(), new Point()));
    }
}
