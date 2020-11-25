/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Template_method {

    /**
     * Паттерн шаблонный метод необходим для определения скелета алгоритма,
     * он перекладывает ответственность за некоторые его шаги на подклассы.
     * Паттерн позволяет подклассам переопределять шаги алгоритма, не меняя его общей структуры.
     */

    //шаблонный метод
    abstract static class DocWork{
        //Некоторые методы общие, можем прямо тут расписать
        void loadDoc(){
            System.out.println("DocLoaded");
        }
        //Какие то потом
        abstract void rework();
        abstract void exit();
    }

    //Подлассы реализуют шаги сами, не трогая шаблонный метод
    static class PDF extends DocWork{

        @Override
        void rework() {
            System.out.println("Обработка PDF");
        }

        @Override
        void exit() {
            System.out.println("Конец PDF");
        }
    }
    static class CSV extends DocWork{

        @Override
        void rework() {
            System.out.println("Обработка CSV");
        }

        @Override
        void exit() {
            System.out.println("Конец CSV");
        }
    }

    public static void main(String[] args) {
        DocWork docWork;
        //Выберем стратегию в зависимости от наших условий
        if (true) {
            docWork = new PDF();
        }
        else {
            docWork = new CSV();
        }
        docWork.loadDoc();
        docWork.rework();
        docWork.exit();

    }
}
