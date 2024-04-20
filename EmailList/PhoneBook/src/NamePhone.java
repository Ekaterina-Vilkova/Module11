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
                System.out.println(key + " - " + phoneBook.get(key));
            }
        }
        return "";
    }

    public String getPhone(String phone) {
        for (HashSet<String> value : phoneBook.values()) {
            if (phone.equals(value)) {
                System.out.println(phoneBook.get(value) + " - " + value);
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