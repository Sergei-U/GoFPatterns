/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Abstract {

        interface Abstract_MakreFree {
            void print();
        }

        static class Chicken implements Abstract_MakreFree {

            @Override
            public void print() {
                System.out.println("CheckenFree");
            }
        }
        static class Onion implements Abstract_MakreFree {

            @Override
            public void print() {
                System.out.println("Onion Free");
            }
        }

        interface TestFactory {
            Abstract_MakreFree makeFree();
        }

        static class OnionFactory implements TestFactory {

            @Override
            public Abstract_MakreFree makeFree() {
                return new Onion();
            }
        }
        static class ChickenFactory implements TestFactory {

            @Override
            public Abstract_MakreFree makeFree() {
                return new Chicken();
            }
        }

    public static void main(String[] args) {
        TestFactory testFactory;
        if (true) {
            testFactory = new ChickenFactory();
            testFactory.makeFree().print();
        }
        else {
            testFactory = new OnionFactory();
            testFactory.makeFree().print();
        }
    }
}
