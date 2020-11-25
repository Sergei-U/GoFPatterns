/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Command {

    /**
     * Паттерн команда преобразует запросы в объекты,
     * благодаря чему мы можем передавать их как аргументы в методы,
     * а также делать из них очередь, логировать и отменять.
     */

    //Класс кнопки
    static class Button{
        String buttonName;
        Button(String buttonName){
            this.buttonName=buttonName;
        }
        void pressButton(){
            System.out.println("Whoops, button pressed");
        }
    }

    //Интерфейс команд
    public interface Command{
        void execute();
    }

    //Команда нажатия на кнопку, инкапсулированная
    public static class PressTheButtonNow implements Command{
        Button thebutton;
        PressTheButtonNow(Button button){
            this.thebutton=button;
        }

        @Override
        public void execute() {
            thebutton.pressButton();
        }
    }
    //И теперь нам необходим вызывающий методы класс (англ. Invoker =) )
    public static class Invoker{
        private Command buttonPressComand;
        Invoker(Command command){
            this.buttonPressComand = command;
        }
        public void press(){
            buttonPressComand.execute();
        }
    }


    public static void main(String[] args) {
        Button button = new Button("Help button");
        Command commandThePress = new PressTheButtonNow(button); ;
        Invoker invoker = new Invoker(commandThePress);
        invoker.press();
    }
}
