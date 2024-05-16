import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        NamePhone namePhone = new NamePhone();
        System.out.println("Введите номер, имя или команду:");
        while (true) {
            String name;
            String phone;
            String regexName = "[А-Я]{1}[а-я]*";
            String regexPhone = "[7][0-9]{10}";
            String text = new Scanner(System.in).nextLine();

            if (text.matches(regexName)) {
                name = text;
                if (namePhone.phoneBook.keySet().contains(name)) {
                    namePhone.getName(name);
                } else {
                    System.out.println("Такого абонента нет в телефонной книге.");
                    System.out.println("Введите номер телефона для абонента " + "\"" + name + "\"");
                    String inputPhone = new Scanner(System.in).nextLine();
                    if (inputPhone.matches(regexPhone)) {
                        namePhone.addNameAndPhone(name, inputPhone);
                    } else {
                        System.out.println("Неверный формат ввода");
                    }
                }
                System.out.println();
                System.out.println("Введите номер, имя или команду:");
                continue;
            }

            if (text.matches(regexPhone)) {
                phone = text;
                if (namePhone.isPhoneAndNameInBook(phone)) {
                    System.out.println(namePhone.getPhone(phone));
                } else {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера " + "\"" + text + "\"");
                    String inputName = new Scanner(System.in).nextLine();
                    boolean formatName = inputName.matches(regexName);
                    if (formatName == true) {
                        namePhone.addNameAndPhone(inputName, phone);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println("Неверный формат ввода");
                    }
                }
                System.out.println();
                System.out.println("Введите номер, имя или команду:");
                continue;
            }

            if (text.equals("LIST")) {
                if (namePhone.phoneBook.isEmpty()) {
                    System.out.println("В телефонной книге пусто");
                } else {
                    System.out.println(namePhone);
                }
                System.out.println("Введите номер, имя или команду:");
            } else {
                System.out.println("Неверный формат ввода");
                System.out.println();
                System.out.println("Введите номер, имя или команду:");
            }
        }
    }
}
