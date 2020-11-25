/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Singleton {
    static class Database {

        //Условный статичный объект одиночка
        private static Database instance;

        private Database() {
            System.out.println("Конструктор");
        }

        public static Database getInstance() {
            if (instance == null) {
                instance = new Database();
            }
            return instance;
        }

        void query(String sql) {
            System.out.println("Метод, в котором выполняются SQL запросы " + sql);
        }

    }

    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.query("Select * from *");
        //Во втором случае новый объект не будет создан
        database = Database.getInstance();
        database.query("Select * from table");
    }
}
