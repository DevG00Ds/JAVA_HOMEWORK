import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;

public class HOMEWORK_task_6 {
    static int id = 1;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook(id, "MSI", "GF75", "Black",
                                    8, 2400,
                                    "Intel", "Core i5 7500", 4, 3.2,
                                    1024,
                                    "IPS", 14.2);
        id++;

        Notebook notebook2 = new Notebook(id, "Acer", "Aspire 3", "Black",
                                    8, 2400,
                                    "AMD", "Ryzen 5 3500U", 4, 2.1,
                                    256,
                                    "IPS", 15.6);
        id++;

        Notebook notebook3 = new Notebook(id, "Apple", "MacBook Air", "Midnight",
                                    8, 3200,
                                    "Apple", "M2", 8, 3.5,
                                    256,
                                    "IPS", 13.6);
        id++;

        Notebook notebook4 = new Notebook(id, "ASUS", "TUF Gaming F17", "Graphite Black",
                                    16, 3200,
                                    "Intel", "Core i5 11400H", 6, 2.7,
                                    512,
                                    "IPS", 17.3);
        id++;

        Notebook notebook5 = new Notebook(id, "ASUS", "TUF Gaming F17", "Silver",
                                    16, 3200,
                                    "Intel", "Core i5 11400H", 6, 2.7,
                                    1024,
                                    "AMOLED", 17.3);
        id++;

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5));
        System.out.println("Ноутбуки загружены. Введите параметр для фильтрации : ");
        System.out.println("1 - По названию производителя.");
        System.out.println("2 - По модели процессера.");
        System.out.println("3 - По обьему оперативной памяти.");
        System.out.println("4 - По обьему жесткого диска");

        System.out.print("Введите параметр: ");
        String text = input.nextLine();

        Set<Notebook> fNotebooks = filter(text, notebooks);
        if (fNotebooks != null) {
            for (Notebook nb: fNotebooks) {
                System.out.println(nb + "\n");
            }
        }
    }

    public static Set<Notebook> filter(String text, Set<Notebook> notebooks) {
        Set<Notebook> fNotebooks = new HashSet<>();
        int min, max;
        switch (text) {
            case "1":
                System.out.print("Введите название прозводителя: ");
                String company = input.nextLine().toLowerCase();
                for (Notebook notebook: notebooks) {
                    if (notebook.company.toLowerCase().equals(company)) {
                        fNotebooks.add(notebook);
                    }
                }
                break;

            case "2":
                System.out.print("Введите производителя процессера: ");
                String CPUcompany = input.nextLine().toLowerCase();
                System.out.print("Введите модель процессера: ");
                String CPUmodel = input.nextLine().toLowerCase();
                for (Notebook notebook: notebooks) {
                    if (notebook.CPUcompany.toLowerCase().equals(CPUcompany) &&
                        notebook.CPUmodel.toLowerCase().equals(CPUmodel)) {
                        fNotebooks.add(notebook);
                    }
                }
                break;

            case "3":
                System.out.println("Введите диапозон минимального и максимального обьема оперативной памяти: ");
                System.out.print("Минимальный обьем оперативной памяти: ");
                min = Integer.parseInt(input.nextLine());
                System.out.print("Максимальный обьем оперативной памяти: ");
                max = Integer.parseInt(input.nextLine());

                for (Notebook notebook: notebooks) {
                    if (min <= notebook.RamSize && notebook.RamSize <= max) {
                        fNotebooks.add(notebook);
                    }
                }
                break;

            case "4":
                System.out.println("Введите диапозон минимального и максимального обьема жесткого диска: ");
                System.out.print("Минимальный обьем жесткого диска: ");
                min = Integer.parseInt(input.nextLine());
                System.out.print("Максимальный обьем жесткого диска: ");
                max = Integer.parseInt(input.nextLine());

                for (Notebook notebook: notebooks) {
                    if (min <= notebook.HDDsize && notebook.HDDsize <= max) {
                        fNotebooks.add(notebook);
                    }
                }
                break;
            default:
                System.out.println("Неверный параметр");
                return null;
        }
        return fNotebooks;
    }
}