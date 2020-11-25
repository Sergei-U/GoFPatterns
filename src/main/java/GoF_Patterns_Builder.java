/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class GoF_Patterns_Builder {
    static class Salad{
    //Различные вариации салатов
    //вообще много чего тут может быть
    //всё, чем салаты отличаются между собой
}
//Интерфейс строителя салатов =)
interface Builder{
    void clean(); //Помыть тарелку
    void addVegetables(String s);
    void addSouce();
    void setWeight(int weight);//Размер порции например
}

static class SaladBuilder implements Builder{
    Salad salad;
    @Override
    public void clean() {
        System.out.println("Моем тарелку");
    }

    @Override
    public void addVegetables(String s) {
        System.out.println("Добавляем овощи: "+s);
    }

    @Override
    public void addSouce() {
        System.out.println("Добавляем соус");
    }

    @Override
    public void setWeight(int weight) {
        System.out.println("Делаем порцию весом : "+ weight);
    }

    Salad getSalad(){
        return new Salad();
    }
}

static class SaladRecipe{
    //тут уже рецепт какого то конкретного салата
    void makeSalad(Builder builder){
        builder.clean();
        builder.addVegetables("Огурцы");
        builder.addVegetables("Помидоры");
        builder.addSouce();
        builder.setWeight(15);
    }

    //тут уже альтернативного салата
    void makeSaladAlt(Builder builder){
        builder.clean();
        builder.addVegetables("Ананасы");
        builder.addVegetables("Курица");
        builder.addSouce();
        builder.setWeight(5);
    }
}


    public static void main(String[] args) {
        SaladRecipe saladRecipe = new SaladRecipe();
        SaladBuilder saladBuilder = new SaladBuilder();

        saladRecipe.makeSalad(saladBuilder);
        Salad salad = saladBuilder.getSalad();

    }
}

