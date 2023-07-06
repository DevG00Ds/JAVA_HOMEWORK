import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;


public class HOMEWORK_4 {

    static Random random = new Random();

    public static void main(String[] args) {
        int len_1 = GenInt(1, 5);
        int len_2 = GenInt(1, 5);

        Deque<Object> dq1 = intToDeque(randomList(len_1));
        Deque<Object> dq2 = intToDeque(randomList(len_2));
        System.out.println("Deque_1 => " + dq1);
        System.out.println("Deque_2 => " + dq2 + "\n");

        int num1 = intFromDeque(dq1);
        int num2 = intFromDeque(dq2);
        System.out.println("Число 1 : => " + num1);
        System.out.println("Число 2 : => " + num2 + "\n");

        int sum = num1 + num2;
        int mul = num1 * num2;
        System.out.println("Сложение списка (+) => " + sum);
        System.out.println("Умножение списка (*) => " + mul + "\n");

        System.out.println("Новый список : " + intToLinkedList(sum));
        System.out.println("Новый список : " + intToLinkedList(mul));
    }

    public static Deque<Object> intToDeque(int num) {
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num *= -1;
        }
        Deque<Object> dq = new ArrayDeque<>();
        while (num != 0) {
            dq.addLast(num % 10);
            num /= 10;
        }
        if (negative) {
            dq.addLast("-");
        }
        return dq;
    }

    public static int intFromDeque(Deque<Object> dq) {
        int sign = 1;
        int multipler = 1;
        int res = 0;
        if (dq.peekLast() == "-") {
            sign = -1;
            dq.pollLast();
        }
        for (Object number : dq) {
            res += (int)number * multipler;
            multipler *= 10;
        }
        return res * sign;
    }

    public static LinkedList<Object> intToLinkedList(int num) {
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num *= -1;
        }
        LinkedList<Object> lst = new LinkedList<>();
        while (num != 0) {
            lst.addFirst(num % 10);
            num /= 10;
        }
        if (negative) {
            lst.addFirst("-");
        }
        return lst;
    }

    public static int GenInt(int min, int max) {
        if (min >= max) {
            throw new IllegalStateException("min должен быть больше max");
        }
        max -= min;
        max += 1;
        return (int) (random.nextDouble() * max) + min;
    }

    public static int randomList(int len) {
        if (len < 1) {
            throw new IllegalStateException("Длинна должна быть больше 0");
        }
        int min = (int) Math.pow(10, len - 1);
        int max = (int) Math.pow(10, len) - 1;
        int numberLen = GenInt(min, max);
        if (delEvenNumbers()) {
            numberLen *= -1;
        }
        return numberLen;
    }

    public static boolean delEvenNumbers() {
        if (GenInt(0, 1) == 1) {
            return true;
        }
        return false;
    }

}