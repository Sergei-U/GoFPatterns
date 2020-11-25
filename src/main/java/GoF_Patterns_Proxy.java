/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Proxy {

    /**
     * Заместитель — это структурный паттерн, благодаря которому можно
     * вместо реальных объектов использовать объекты-заменители.
     * Эти объекты являются посредником передачи вызова к оригинальному
     * объекту, позволяя сделать что-то до вызова, а что-то — после.
     */

    //Интерфейс  с для работы с БД (возможно какой-то библиотекой по типу jdbc)
    interface Database{
        String connect(String ConnectionString);
        String querry(String SQL);
    }
    //класс для работы с БД
    static class DatabaseWorker implements Database{

        @Override
        public String connect(String ConnectionString) {
            System.out.println("Connected to DB");
            return "Connected to DB "+ConnectionString;
        }

        @Override
        public String querry(String SQL) {
            return "0 row affected";
        }
    }

    //класс для кэширования
    static class DatabaseCache extends DatabaseWorker{
        private DatabaseWorker service;
        private boolean needReset;
        private String connectCache;
        private String querryCache;
        DatabaseCache(DatabaseWorker service){
            this.service=service;
            this.needReset=false;
        }

        @Override
        public String connect(String ConnectionString) {
            if ((connectCache==null)||(needReset)){
                connectCache =service.connect(ConnectionString);
            }
            return connectCache;
        }

        @Override
        public String querry(String SQL) {
            if ((querryCache==null)||(needReset)){
                querryCache=service.querry(SQL);
            }
            return querryCache;
        }
    }
    // Класс GUI, который использует сервисный объект. Вместо
    // реального сервиса, мы подсунем ему объект-заместитель. Клиент
    // ничего не заметит, так как заместитель имеет тот же
    // интерфейс, что и сервис.
    static class DatabaseManager{
        DatabaseWorker databaseWorker;
        DatabaseManager(DatabaseWorker databaseWorker){
            this.databaseWorker=databaseWorker;
        }
        void makeConnection(String connectionString){
            databaseWorker.connect(connectionString);
        }
        String runQuerry(String SQL){
            return databaseWorker.querry(SQL);
        }
    }

    public static void main(String[] args) {
        //Создаем наши объекты,
        //Вкладывая их друг в друга, как матрешки
        DatabaseWorker databaseWorker =new DatabaseWorker();
        DatabaseCache databaseCache = new DatabaseCache(databaseWorker);
        DatabaseManager databaseManager = new DatabaseManager(databaseCache);

        databaseManager.makeConnection("127.0.0.1");
        databaseManager.runQuerry("Select * from *");
    }

}
