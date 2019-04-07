package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {

        Breakfast apple1 = new Apple();
        Breakfast apple2 = new Apple();
        Breakfast chocolate1 = new Chocolate();

        Breakfast sandwich1 = new Sandwich();
        Breakfast sandwich2 = new Sandwich();
        Breakfast apple3 = new Apple();

        CompositeFood compositeFood = new CompositeFood();
        CompositeFood compositeFood1 = new CompositeFood();
        CompositeFood compositeFood2 = new CompositeFood();

        compositeFood1.addComponent(apple1);
        compositeFood1.addComponent(apple2);
        compositeFood1.addComponent(chocolate1);

        compositeFood2.addComponent(sandwich1);
        compositeFood2.addComponent(sandwich2);
        compositeFood2.addComponent(apple3);

        compositeFood.addComponent(compositeFood1);
        compositeFood.addComponent(compositeFood2);

        compositeFood1.getFood();
        compositeFood2.getFood();
        compositeFood.getFood();
    }
}

interface Breakfast {
    void getFood();
}

class Apple implements Breakfast {
    @Override
    public void getFood() {
        System.out.println("It is apple");
    }
}

class Sandwich implements Breakfast {
    @Override
    public void getFood() {
        System.out.println("It is sandwich");
    }
}

class Chocolate implements Breakfast {
    @Override
    public void getFood() {
        System.out.println("It is chocolate");
    }
}

class CompositeFood implements Breakfast {
    List<Breakfast> components = new ArrayList<>();

    public void addComponent(Breakfast component) {
        components.add(component);
    }

    public void removeComponent(Breakfast component) {
        components.remove(component);
    }

    @Override
    public void getFood() {
        for (Breakfast b : components) {
            b.getFood();
        }
    }
}