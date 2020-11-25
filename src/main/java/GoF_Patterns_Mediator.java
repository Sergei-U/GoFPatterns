/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Mediator {

    /**
     * Паттерн посредник предназначен для того, чтобы снизить связность множества
     * классов между собой благодаря перемещению этих связей в класс-посредник.
     */

    //Общий интерфейс посредника
    interface Mediator {
        void trynotify(Component component, String string);

    }

    static class Dialog implements Mediator {

        @Override
        public void trynotify(Component component, String string) {
            System.out.println(component + " " + string);
        }
    }

    //Общий класс компонентов для общения
    static class Component {
        Mediator mediator;

        Component(Dialog dialog) {
            this.mediator = dialog;
        }

        void OnClick() {
            mediator.trynotify(this, "Click");
        }
    }

    class Button extends Component {

        Button(Dialog dialog) {
            super(dialog);
        }

    }

    static class TextBox extends Component {
        TextBox(Dialog dialog) {
            super(dialog);
        }

        //Общей связи нет, есть только такой метод
        void OnClick() {
            mediator.trynotify(this, "Click TextBox");
        }
    }


    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        Component component = new Component(dialog);
        component.OnClick();

        TextBox textBox = new TextBox(dialog);
        textBox.OnClick();
    }

}
