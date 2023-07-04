import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HOMEWORK_3 {

    static Random random = new Random();

    public static void main(String[] args) {
        int lstlen = GenInt(1, 50);
        int lstmin = GenInt(-10, -1);
        int lstmax = GenInt(0, 10);
        ArrayList<Integer> list = randomList(lstlen, lstmin, lstmax);
        System.out.println("Исходный список: ");
        System.out.println(list);

        for (int i = 0; i < lstlen; i++) {
            if (delEvenNumbers(list.get(i))) {
                list.remove(i);
                i--;
                lstlen--;
            }
        }

        System.out.println("Список после удаления четных чисел : ");
        System.out.println(list);

        System.out.println("Максимальное число : " + Collections.max(list));

        System.out.println("Минимальное число : " + Collections.min(list));

        double average = averageNumber(list);
        System.out.println("Среднее значение : " + average);
    }

    public static int GenInt(int min, int max) {
        if (min >= max) {
            throw new IllegalStateException("min должен быть больше max");
        }
        max -= min;
        max += 1;
        return (int) (random.nextDouble() * max) + min;
    }

    public static ArrayList<Integer> randomList(int len, int min, int max) {
        if (len < 1) {
            throw new IllegalStateException("Длинна должна быть больше 0");
        }
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(GenInt(min, max));
        }
        return list;
    }

    public static boolean delEvenNumbers(int numbers) {
        if (numbers % 2 == 0) {
            return true;
        }
        return false;
    }

    public static double averageNumber(ArrayList<Integer> list) {
        int size = list.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        return (double) sum / (double) size;
    }
}
