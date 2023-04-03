package Lesson1_HomeWork;

public class Main {
    public static void main(String[] args) {

        // Создаем полосу препятствий
        Course c = new Course(new Cross(80), new Water(3), new Wall(5));

        // Создаем команду
        Team team = new Team("Отважные", new Human("Александр"), new Cat("Кай"), new Dog("Оскар"));

        // Просим команду пройти полосу
        c.doIt(team);
        
        System.out.println("\nWinners:");
        team.passedTheDistance();

        // Показываем результаты
        System.out.println("\nResult:");
        team.showResults();
    }
}
