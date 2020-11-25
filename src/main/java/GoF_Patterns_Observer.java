import java.util.HashMap;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Observer {

    /**
     * Паттерн наблюдатель создаёт механизм подписки,
     * позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
     */

    //Класс издателя
    static class EventManager{
        private HashMap<String,AlertsListener> listeners;
        EventManager(){
            listeners = new HashMap<>();
        }


        void subScribe(String notify, AlertsListener alertsListener){
            listeners.put(notify,alertsListener);
        }
        void tyrnotify(String notify, String object) {
            listeners.forEach((string, listner)->listner.update(object));

        }
    }

    //Класс издатель
    static class Editor{
        EventManager eventManager;

        Editor(){
            eventManager = new EventManager();
        }
        //Некоторое событие, о котором надо уведомить
        void print(){
            /**
             * Список методов дел
             */
            eventManager.tyrnotify("Notification","Объект)");
        }
    }
    // Общий интерфейс подписчиков
    interface EventListener {
        void update(String string);
    }


    //Конкретный класс слушателя
    static class AlertsListener implements EventListener{


        @Override
        public void update(String string) {
            System.out.println(string);
        }
    }



    public static void main(String[] args) {
        Editor editor = new Editor();
        AlertsListener alertsListener = new AlertsListener();
        editor.eventManager.subScribe("Notify",alertsListener);

    }
}
