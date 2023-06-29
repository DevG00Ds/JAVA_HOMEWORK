import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * HOMEWORK_2_task1_task2
 */
public class HOMEWORK_2_task1_task2 {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(HOMEWORK_2_task1_task2.class.getName());
    private static SimpleFormatter simple_Formatter = new SimpleFormatter();

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("HOMEWORK_2_task1_task2.log", true);
            fileHandler.setFormatter(simple_Formatter);
            logger.addHandler(fileHandler);
            task1();
            task2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void task1() {
        int[] array = { 5, 4, 8, 9, 1, 2, 3 };

        logger.info(Arrays.toString(array) + "Исходное состояние");

        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            logger.info(Arrays.toString(array) + "Итерация" + i + "\n");
        }
    }

    public static void task2() {
        int numbers_1;
        int numbers_2;
        int result;
        char func;

        StringBuilder stringBuilder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа : ");
        numbers_1 = scanner.nextInt();
        numbers_2 = scanner.nextInt();
        System.out.println("Выбирите оператор с которым хотите работать (+)(-)(*)(/) : ");
        func = scanner.next().charAt(0);
        switch (func) {
            case '+':
                result = numbers_1 + numbers_2;
                stringBuilder.append(result);
                logger.info(stringBuilder.toString());
                break;
            case '-':
                result = numbers_1 - numbers_2;
                stringBuilder.append(result);
                logger.info(stringBuilder.toString());
                break;
            case '*':
                result = numbers_1 * numbers_2;
                stringBuilder.append(result);
                logger.info(stringBuilder.toString());
                break;
            case '/':
                result = numbers_1 / numbers_2;
                stringBuilder.append(result);
                logger.info(stringBuilder.toString());
                break;
            default:
                // System.out.println(" Ошибка ");
                logger.log(Level.WARNING, " Ошибка ");
                return;
        }
        System.out.printf(numbers_1 + " " + func + " " + numbers_2 + " " + " = " + result);
    }
}
