/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Bridge {
    // Мост — это структурный паттерн проектирования,
    // который разделяет один или несколько классов на две отдельные иерархии:
    // абстракцию и реализацию, чтобы можно было изменять их независимо друг от друга.

    //класс продавца
    static class Seller{
        protected Terminal terminal;
        Seller(Terminal terminal){
            this.terminal=terminal;
        }
        void makeBill(int cost){
            terminal.bill(cost);
        }
        void startWork(){
            terminal.powerOn();
        }
        void restartWork(){
            terminal.makeXreport();
            terminal.powerOff();
            terminal.powerOn();
        }
        void endWork(){
            terminal.makeZreport();
            terminal.powerOff();
        }

    }

    //интерфейс терминала
    interface Terminal{
        void powerOn();
        void powerOff();
        void makeZreport();
        void makeXreport();
        void bill(int cost);
    }

    //Также мы теперь можем расширить класс продавца, не трогая его методы
    public static class AdvancedSeller extends Seller{
        AdvancedSeller(Terminal terminal) {
            super(terminal);
        }

        //функция печати чека со стоимостью услуг 0
        void zerobill(){
            terminal.bill(0);
        }
    }

    //У каждой конечной кассы будет один фискальный регистратор
    //касса тут понятие общее, а вот фискальный регистратор – та штука, что печатает чеки

    static class KassaOne implements Terminal{
        @Override
        public void powerOn() {}
        @Override
        public void powerOff() {}
        @Override
        public void makeZreport() {}
        @Override
        public void makeXreport() {}
        @Override
        public void bill(int cost) {
            System.out.println(cost);
        }
    }
    static class KassaTwo implements Terminal{
        @Override
        public void powerOn() {}
        @Override
        public void powerOff() {}
        @Override
        public void makeZreport() {}
        @Override
        public void makeXreport() {}
        @Override
        public void bill(int cost) {
            System.out.println(cost);
        }
    }


    public static void main(String[] args) {
        //Создаем кассу
        KassaOne kassaOne = new KassaOne();
        //Создаем продавца
        Seller seller = new Seller(kassaOne);
        seller.makeBill(125);

        //Создаем вторую кассу
        KassaTwo kassaTwo = new KassaTwo();
        //Создаем улучшенного продавца
        AdvancedSeller advancedSeller = new AdvancedSeller(kassaTwo);
        advancedSeller.startWork();//Свойства обычного продавца
        advancedSeller.zerobill();//дополнительное свойство

    }
}
