import java.util.ArrayList;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Chain_of_responsibility {

    /**
     * Паттерн (цепочка обязанностей) позволяет передавать по очереди по цепочке обработчиков.
     * Притом каждый обработчик решает, может он обработать запрос, или передать дальше по цепи.
     */

    //Базовый интерфейс всех компонентов
    //Передается текст после нажатия на кнопку
    interface BaseText {
        void print();
    }

    //класс наших базовых компонентов
    abstract static class Component implements BaseText {
        String HelpText;
        //Контейнер
        Container container;

        //Метод Help вызывает подсказку из себя, либо из следующего вложенного контейнера
        void help() {
            if (HelpText != null) {
                // Показать подсказку
                System.out.println("Подсказка");
            } else
                container.help();
        }
    }

    abstract static class Container extends Component {
        ArrayList children = new ArrayList();
        void add(Component child) {
            children.add(child);
            child.container = this;

        }
    }
    static class Other extends Container{
        String HelpText;
        @Override
        public void print() {
            if (HelpText != null) {
                // Какая-то подсказка пользователю для пункта "прочее"
                System.out.println("Какая то подсказка пользователю для пункта прочее");
            }
            else super.help();
        }
    }
    static class CallSpec extends Container{
        String HelpText;
        @Override
        public void print() {
            if (HelpText != null) {
                // Попытка соединить со специалистом
                System.out.println("Попытка соединить со специалистом");
            }
            else super.help();
        }
    }
    static class Dialog extends Container{
        String HelpText;
        @Override
        public void print() {
            if (HelpText != null) {
                // Попытка соединить со специалистом
                System.out.println("Запчасть диалога");
            }
            else super.help();
        }
    }

    public static void main(String[] args) {
        Other other = new Other();
        other.HelpText = "test text";
        CallSpec callSpec = new CallSpec();
        callSpec.HelpText = "1.2.3";
        Dialog dialog = new Dialog();
        dialog.HelpText="Часть подсказки в диалоге";
        dialog.add(other);
        dialog.add(callSpec);

        //помощь
        dialog.print();
    }
}
