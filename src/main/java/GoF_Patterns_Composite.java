import java.util.ArrayList;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Composite {

    /**Компоновщик — это структурный паттерн проектирования,
    * который позволяет сгруппировать множество объектов в древовидную структуру,
    * а затем работать с ней так, как будто это единичный объект.
     */
    //общий интерфейс(свойства) для всех предметов в коробках,
    // в нашем случае свойство – они могут быть доставлены
    interface CustomItem{
        void supply();
        void print();
    }
    // минимальный компонент
    class Item implements CustomItem{
        int weight;
        int size;
        Item(int weight,int size){
            this.weight=weight;
            this.size=size;
        }

        @Override
        public void supply() {
            System.out.println("Do supply");
        }

        @Override
        public void print() {
            System.out.println("Print about smth");
        }
    }

    //Компоненты могут расширять другие компоненты
    static class Book extends Item{
        int numberofpages;
        Book(int weight, int size,int numberofpages) {
            super(weight, size);
            this.numberofpages=numberofpages;
        }
        public void getBookText(){
            System.out.println("Как будто печатаем текст книги");
        }
    }

    //Ящик для хранения всего
    static class Box implements CustomItem{
        ArrayList arrayList ;

        Box(){
            arrayList = new ArrayList();
        }
        public void add(CustomItem customItem){
            arrayList.add(customItem);
        }

        //доставка каждого компонента в ящике
        @Override
        public void supply() {

        }

        //печать каждого названия
        @Override
        public void print() {

        }
    }


    public static void main(String[] args) {
        Box bookbox = new Box();
        bookbox.add(new Book(10,20,10));
        bookbox.add(new Book(1,2,31));
        Box custombox = new Box();
        custombox.add(bookbox);
    }
}
