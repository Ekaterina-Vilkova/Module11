import java.util.Scanner;

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

                if (!name.equals(namePhone.phoneBook.keySet())) {
                    namePhone.getName(name); // если контакт есть в телефонной книге, то выводит данные
                } // если прописываю здесь else, что код ниже совсем перестает работать


                System.out.println("Такого абонента нет в телефонной книге.");
                System.out.println("Введите номер телефона для абонента " + "\"" + name + "\"");
                String inputPhone = new Scanner(System.in).nextLine();
                if (inputPhone.matches(regexPhone)) {
                    namePhone.addNameAndPhone(name, inputPhone);
                    System.out.println("Контакт сохранен!");

                }

                System.out.println();
                System.out.println("Введите номер, имя или команду:");
                continue;
            }

            if (text.matches(regexPhone)) {
                for (String phones : namePhone.phoneBook.keySet()) {
                    if (!text.equals(namePhone.phoneBook.keySet())) {
                        System.out.println(namePhone.getName(phones)); // если телефон есть в телефонной книге, что выводит данные
                    } // если прописываю здесь else, что код ниже совсем перестает работать
                }

                namePhone.getPhone(text);
                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Введите имя абонента для номера " + "\"" + text + "\"");
                String inputName = new Scanner(System.in).nextLine();
                boolean formatName = inputName.matches(regexName);
                if (formatName == true) {
                    namePhone.addNameAndPhone(inputName, text);
                    System.out.println("Контакт сохранен!");

                }
                System.out.println();
                System.out.println("Введите номер, имя или команду:");
                continue;
            }


            if (text.equals("LIST")) {
                System.out.println(namePhone);

            } else {
                System.out.println("Неверный формат ввода");
                System.out.println();
                System.out.println("Введите номер, имя или команду:");
            }
        }
    }
}