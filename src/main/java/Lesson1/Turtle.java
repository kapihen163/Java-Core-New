package Lesson1;

public class Turtle extends Animal {

    public Turtle(String name, String color, int age) {
        super(name, color, age);

    }

    public void voice() {
        System.out.println("черепаха кряхтит");
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

}
