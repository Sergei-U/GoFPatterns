/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_State {

    /**
     * Паттерн состояние позволяет менять своё поведение в зависимости от своего состояния,
     * притом извне кажется, что сменился класс объекта.
     * Паттерн основан на концепции машины-состоянии, также известной как конечный автомат.
     */


    abstract static class State {
        Article article;

        State(Article article) {
            this.article = article;
        }

        //Наш абстрактный метод, который для разных состояний будет разный
        abstract void publish();
    }

    //Конкретное состояние
    static class Draft extends State {

        Draft(Article article) {
            super(article);
        }

        @Override
        void publish() {

        }
    }

    //Ещё одно состояние
    static class Moderation extends State {

        Moderation(Article article) {
            super(article);
        }

        @Override
        void publish() {

        }
    }

    static class Article {
        private State state;

        public Article() {
            this.state = new Draft(this);
        }

        public void changeState(State state) {
            this.state = state;
        }
    }

    static class UI {
        private Article article;

        public UI(Article article) {
            this.article = article;
        }

        void changeState() {
            article.changeState(new Moderation(article));
        }
    }


    public static void main(String[] args) {
        Article article = new Article();
        UI ui = new UI(article);
        ui.changeState();
    }
}
