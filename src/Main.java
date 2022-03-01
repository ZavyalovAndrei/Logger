import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести размер списка.");
        System.out.println("Введите размер списка (должно быть целое число больше 0).");
        int listSize = checkEntry();
        logger.log("Пользователь ввел: " + listSize);
        logger.log("Просим пользователя ввести верхнюю границу списка.");
        System.out.println("Введите верхнюю границу значений элементов в списке (должно быть целое число больше 0).");
        int arraySize = checkEntry();
        logger.log("Пользователь ввел: " + arraySize);
        logger.log("Просим пользователя ввести данные для фильтрации.");
        System.out.println("Введите число для фильтрации списка (должно быть целое число больше 0).");
        Filter filter = new Filter(checkEntry());
        logger.log("Пользователь ввел: " + filter.treshold);
        logger.log("Создаем случайный список.");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            list.add(random.nextInt(listSize));
        }
        System.out.println("Произвольный список:");
        printArray(list);
        List <Integer> filteredList = filter.filterOut(list);
        logger.log("Выводим результат на экран.");
        System.out.println("Отсортированный список:");
        printArray(filteredList);
        logger.log("Завершаем программу.");
    }

    private static int checkEntry() {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        String errorMessage = "Ошибка. Введите целое число больше 0";
        while (true) {
            try {
                int enter = Integer.parseInt(scanner.nextLine());
                if (enter > 0) {
                    return enter;
                } else {
                    System.out.println(errorMessage);
                    logger.log(errorMessage);
                }
            } catch (NumberFormatException err) {
                System.out.println(errorMessage);
                logger.log(errorMessage);
            }
        }
    }

    private static void printArray(List<Integer> array) {
        for (int value : array) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}