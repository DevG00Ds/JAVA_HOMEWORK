import java.util.Scanner;

/**
 * HOMEWORK_1_task1 (сумма чисел от 1 до n)
 */
public class HOMEWORK_1_task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число N : ");
        int n  = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum = sum + i;
        }
        System.out.println("Сумма чисел N равна : " + sum);
    }

}