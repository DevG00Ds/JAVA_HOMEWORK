import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HOMEWORK_5 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> Phones = new HashMap<>();
        Map<String, Integer> Count = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();

        String phone_name;
        String name;
        String phone;
        String[] name_phone_list;

        try (BufferedReader file = new BufferedReader(new FileReader("phone_number.data"))) {
            phone_name = file.readLine();
            while(phone_name != null) {
                name_phone_list = phone_name.split(" ");
                name = name_phone_list[0];
                phone = name_phone_list[1];
                if (Phones.containsKey(name)) {
                    Phones.get(name).add(phone);
                    Count.put(name, Count.get(name) + 1);
                }
                else { 
                    Phones.put(name, new ArrayList<>());
                    Phones.get(name).add(phone);
                    Count.put(name, 1);
                    names.add(name);
                }
                phone_name = file.readLine();
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return Count.get(name2) - Count.get(name1);
            }
        });
        
        for (String nname : names) {
            for(String phone_number: Phones.get(nname)) {
                System.out.println(nname + " " + phone_number);
            }
        }
    }
}
