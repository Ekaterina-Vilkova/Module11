import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NamePhone namePhone = new NamePhone();
        System.out.println("Введите номер, имя или команду:");
        while (true) {
            String name = "[А-Я]{1}[а-я]*";
            String phone = "[7][0-9]{10}";
            String text = new Scanner(System.in).nextLine();

            if (Character.isLetter(text.charAt(0))) {
                boolean formatName = text.matches(name);
                if (formatName == true) {
                    namePhone.getName(text);
                    System.out.println("Введите номер телефона для абонента " + "\"" + text + "\"");
                    String inputPhone = new Scanner(System.in).nextLine();
                    boolean formatPhone = inputPhone.matches(phone);
                    if (formatPhone == true) {
                        namePhone.addNameAndPhone(text, inputPhone);
                        System.out.println("Контакт сохранен!");
                        continue;
                    }
                }

            }
            if (Character.isDigit(text.charAt(0))) {
                boolean formatPhone = text.matches(phone);
                if (formatPhone == true) {
                    namePhone.getPhone(text);
                    System.out.println("Введите имя абонента для номера " + "\"" + text + "\"");
                    String inputName = new Scanner(System.in).nextLine();
                    if (formatPhone == true) {
                        namePhone.addNameAndPhone(inputName, text);
                        System.out.println("Контакт сохранен!");
                        continue;
                    }
                }
            }
            if (text.equals("LIST")) {
                System.out.println(namePhone);
            } else {
                System.out.println("Неверный формат ввода");
            }

        }
    }
}