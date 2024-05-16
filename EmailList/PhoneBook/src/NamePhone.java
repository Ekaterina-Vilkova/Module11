import java.util.*;

public class NamePhone {

    TreeMap<String, List<String>> phoneBook = new TreeMap<>();

    public boolean addNameAndPhone(String name, String phone) {
        List<String> number = phoneBook.get(name);
        if (number == null) {
            number = new ArrayList<>();
            phoneBook.put(name, number);
        }
        for (List<String> numbers : phoneBook.values()) {
            if (numbers.contains(phone)) {
                System.out.println("Данный номер пренадлежит другому абоненту");
                phoneBook.remove(name);
                return false;
            }
        }
        number.add(phone);
        System.out.println("Контакт сохранен!");
        return true;
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
        for (List<String> value : phoneBook.values()) {
            if (phone.equals(value)) {
                String print = phoneBook.get(value) + " - " + value;
                System.out.println(print.replaceAll("\\[|\\]", ""));
            }
        }
        return "";
    }

    public boolean isPhoneAndNameInBook(String phone) {
        if (phoneBook.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, List<String>> book : phoneBook.entrySet()) {
            if (book.getValue().contains(phone)) {
                System.out.println(book.getKey() + " - " + phone);

                return true;
            }
        }
        return false;
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