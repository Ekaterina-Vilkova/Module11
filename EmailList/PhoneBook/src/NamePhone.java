import java.util.HashSet;
import java.util.TreeMap;

public class NamePhone {

    TreeMap<String, HashSet<String>> phoneBook = new TreeMap<>();

    public void addNameAndPhone(String name, String phone) {
        HashSet<String> number = phoneBook.get(name);
        if (number == null) {
            number = new HashSet<>();
            phoneBook.put(name, number);
        }
        number.add(phone);
    }

    public String getName(String name) {
        for (String key : phoneBook.keySet()) {
            if (name.equals(key)) {
                String print = key + " - " + phoneBook.get(key);
                System.out.println(print.replaceAll("\\[|\\]", ""));
            }
        }
        return "";
    }

    public String getPhone(String phone) {
        for (HashSet<String> value : phoneBook.values()) {
            if (phone.equals(value)) {
                String print = phoneBook.get(value) + " - " + value;
                System.out.println(print.replaceAll("\\[|\\]", ""));
            }
        }
        return "";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String entry : phoneBook.keySet()) {
            builder.append(entry);
            builder.append(" - ");
            builder.append(phoneBook.get(entry));
            builder.append("\n");
        }
        return builder.toString().replaceAll("\\[|\\]", "");
    }
}