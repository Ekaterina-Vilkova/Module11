import java.util.TreeSet;

public class EmailList {

    TreeSet<String> email = new TreeSet<>();

    public void addNewEmail(String newEmail) {
        this.email.add(newEmail);
    }

    public void listAllEmail() {
        for (String allEmail : email)
            System.out.println(allEmail);
    }
}