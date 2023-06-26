import java.util.Scanner;

/**
 * HOMEWORK_1_task3 Реализовать простой калькулятор
 */
public class HOMEWORK_1_task3 {

    public static void main(String[] args) {
        int numbers_1;
        int numbers_2;
        int result;
        char func;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа : ");
        numbers_1 = scanner.nextInt();
        numbers_2 = scanner.nextInt();
        System.out.println("Выбирите оператор с которым хотите работать (+)(-)(*)(/) : ");
        func = scanner.next().charAt(0);
        switch(func) {
            case '+': result = numbers_1 + numbers_2;
            break;
             case '-': result = numbers_1 - numbers_2;
            break;
             case '*': result = numbers_1 * numbers_2;
            break;
             case '/': result = numbers_1 / numbers_2;
            break;
            default: System.out.println(" Ошибка ");
            return;
        }
        System.out.printf(numbers_1 + " " + func + " " + numbers_2 + " " + " = " + result);
    }
}