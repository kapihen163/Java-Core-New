package Lesson2_HomeWork;

public class Main {
    public static void main(String[] args) {
        /**
         * 1 Напишите метод на вход которого подается двумерный строковый массив размером 4х4, при
         * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
         *
         * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int, и
         * просуммировать их. Если в каком-то элементе массива не удалось преобразование
         * (например, в ячейке лежит символ вместо числа), необходимо бросить исключение
         * MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
         *
         * 3 В методе main() необходимо вызвать полученный метод, обработать возможные исключения
         * MySizeArrayException и MyArrayDataException, и вывести результат расчета.
         */

        String[][] correctMatrix = {
                {"3", "2", "3", "3"},
                {"3", "6", "1", "4"},
                {"0", "2", "7", "2"},
                {"0", "2", "7", "2"}
        };
        String[][] wrongSizeMatrix = {
                {"3", "2", "3", "3"},
                {"6", "1"},
                {"0", "2", "7", "3"},
                {"0", "2", "7", "3"}
        };
        String[][] wrongChar = {
                {"3", "2", "3", "3"},
                {"6", "1", "", "3"},
                {"0", "2", "7", "3"},
                {"0", "2", "7", "3"}
        };

        try {
            System.out.println(Converter.strConverter(correctMatrix));
        } catch (CustomException e) {
            e.getMessage();
        }


        try {
            System.out.println(Converter.strConverter(wrongSizeMatrix));
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(Converter.strConverter(wrongChar));
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }

    }
}
