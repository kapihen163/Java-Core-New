package Lesson7_Class;

public class CarElement {
    private String name;

    @Override
    public String toString() {
        return "CarElement{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
