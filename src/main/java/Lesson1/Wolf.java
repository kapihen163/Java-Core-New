package Lesson1;

public class Wolf extends Animal {

    public Wolf(String name, String color, int age) {
        super(name, color, age);
    }

    public void voice() {
        System.out.println("волк воет");
    }
}
