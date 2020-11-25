/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Memento {

    /**
     * Второе название этого паттерна — снимок.
     * Он позволяет сохранять и восстанавливать прошлые состояния объектов без подробностей их реализации.
     */

    //Класс карты
    static class EditMap {
        //Внутреннее состояние объектов, которые и надо хранить
        private int x, y;
        private String string;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        Snapshot createSnapshot() {
            return new Snapshot(this, x, y, string);
        }
    }

    static class Snapshot {
        EditMap editMap;
        private int x, y;
        private String string;

        public Snapshot(EditMap editMap, int x, int y, String string) {
            this.editMap = editMap;
            this.x = x;
            this.y = y;
            this.string = string;
        }

        //Метод для восстановления из снапшота
        void restore() {
            editMap.setX(x);
            editMap.setY(y);
            editMap.setString(string);
        }
    }

    // Опекуном может выступать класс команд (см. паттерн Команда).
    // В этом случае команда сохраняет снимок состояния объекта-
    // получателя, перед тем как передать ему своё действие. А в
    // случае отмены команда вернёт объект в прежнее состояние

    static class Command {
        EditMap editMap;
        Snapshot backup;

        Command(EditMap editMap) {
            this.editMap = editMap;
        }

        void makeBackup() {
            backup = editMap.createSnapshot();
        }

        void undo() {
            backup.restore();
        }
    }

    public static void main(String[] args) {
        EditMap editMap = new EditMap();
        Command command = new Command(editMap);
        command.makeBackup();
        command.undo();
    }
}
