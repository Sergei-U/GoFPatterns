/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Strategy {

    /**
     * Паттерн стратегия определяет схожие алгоритмы и
     * помещает их в собственные классы, благодаря чему их можно взаимозаменять прямо на ходу в программе.
     */

    //Абстрактная стратегия
    interface Strategy{
        void run(String string);
    }
    //Первая стратегия
    static class FirstStrategy implements Strategy{

        @Override
        public void run(String string) {
            System.out.println("Первая решает по своему "+ string);
        }
    }
    //Вторая
    static class SecondStrategy implements Strategy{

        @Override
        public void run(String string) {
            System.out.println("Вторая по другому "+ string);
        }
    }
    //Класс контекста, работает со стратегиями через общий интерфейс
    static class Context{
        Strategy strategy;
        void setStrategy(Strategy strategy){
            this.strategy=strategy;
        }
        void executeStrategy(String string){
            strategy.run(string);
        }
    }

    public static void main(String[] args) {

        Context context = new Context();
        //в зависимости от условий реализуем стратегию
        if (true){
            context.setStrategy(new FirstStrategy());
        }else{
            context.setStrategy(new SecondStrategy());
        }

        context.executeStrategy("Запускаем стратегию");
    }
}
