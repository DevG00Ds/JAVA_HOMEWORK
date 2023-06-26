/**
 * HOMEWORK_1_task2 Вывести все простые числа от 1 до 1000
 */
public class HOMEWORK_1_task2 {

    public static void main(String[] args) {

        int i, j;

        for (i = 2; i < 1001; i++) {
            int k = 0;
            for (j = 2; j <= i; j++) {
                if ((i % j) == 0)
                    k++;
            }
            if (k < 2)
                System.out.println(i);
        }
    }
}
