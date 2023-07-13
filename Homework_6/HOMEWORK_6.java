package Homework_6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HOMEWORK_6 {

    static int id = 1;
    static Scanner input = new Scanner(System.in);
     
    public static void main(String[] args) {
        notebook notebook_1 = new notebook(id, "MSI", "GF63 Thin", "Black",
                             15.6, "IPS", 8, 2700, 
                             "Intel", "Core i5 11400H", 6, 3.2, 256);
        id++;

        notebook notebook_2 = new notebook(id, "Lenova", "IdeaPad 3", "Grey",
                             15.6, "IPS", 8, 1100,
                             "Intel", "Pentium N5030", 4, 2.4, 256);
        id++;

        notebook notebook_3 = new notebook(id, "Apple", "MacBook Air 13", "Space Grey",
                             13.3, "IPS", 8, 3200, 
                             "Apple", "M1", 8, 3.2, 256);
        id++;

        notebook notebook_4 = new notebook(id, "Xiaomi", "Mi Notebook Pro 15", "Graphite ",
                             15.6, "OLED", 16, 3200, 
                             "AMD", "Ryzen 7 5800H", 8, 3.2, 512);
        id++;

        notebook notebook_5 = new notebook(id, "ASUS", "ivobook 16X M1603QA-MB120", "Blue",
                             16, "IPS", 8, 3300, 
                             "AMD", "Ryzen 5 5600H", 6, 3.3, 512);
        id++;

        Set<notebook> notebooks = new HashSet<>(Arrays.asList(notebook_1,notebook_2,notebook_3,notebook_4,notebook_5));
        System.out.println("Ноутбуки загружены. Введите параметр для фильтрации : ");
        System.out.println("1 - По названию производителя.");
        System.out.println("2 - По модели процессера.");
        System.out.println("3 - По обьему оперативной памяти.");
        System.out.println("4 - По обьему жесткого диска");

        System.out.print("Введите параметр : ");
        String text = input.nextLine();

        Set<notebook> fNotebooks = filter(text, notebooks);
        if(notebooks != null) {
            for (notebook notebook:fNotebooks){
                System.out.println(notebook + "\n");
            }
        }

    }

    public static Set<notebook> filter(String text, Set<notebook> notebooks) {
        Set<notebook> fNotebooks = new HashSet<>();
        int min,max;
        switch(text){
            case "1":
                System.out.println("Введите название прозводителя: ");
                String company = input.nextLine().toLowerCase();
                for (notebook notebook: fNotebooks) {
                    if (notebook.company.toLowerCase().equals(company)){
                        fNotebooks.add(notebook);
                    }
                }
                break;
            
            case "2":
                System.out.println("Введите производителя процессера: ");
                String CPUcompany = input.nextLine().toLowerCase();
                System.out.println("Введите модель процессера: ");
                String CPUmodel = input.nextLine().toLowerCase();
                for (notebook notebook: fNotebooks){
                    if ( notebook.CPUcompany.toLowerCase().equals(CPUcompany)
                    && notebook.CPUmodel.toLowerCase().equals(CPUmodel)){
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

                for( notebook notebook: fNotebooks) { 
                    if ( min <= notebook.RamSize && notebook.RamSize <= max) {
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

                for( notebook notebook: fNotebooks) { 
                    if (min <= notebook.HDDsize && notebook.HDDsize <= max) {
                        fNotebooks.add(notebook);
                    }
                }
                break;

            default:
                System.out.println("Не верно введен параметр!");
                return null;
        }
        return fNotebooks;
    }
}
