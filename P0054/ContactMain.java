package P0054;

import java.util.ArrayList;
import java.util.List;

public class ContactMain {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        List<Contact> list = new ArrayList<>();
        int option = 0;
        int id = 1;
        while (option != 4) {
            menu();
            option = Validation.checkInputLimit(Validation.sc.next());
            switch (option) {
                case 1:
                    System.out.println("--------- Add a Contact ---------");
                    Contact contact = manager.getNewContact(id++);
                    System.out.println(manager.addContact(list, contact) ? "Successful" : "Contact is dupplicated");
                    break;
                case 2:
                    System.out.println(
                            "------------------------------------------- Display all Contact -------------------------------------------");
                    manager.displayAll(list);
                    break;
                case 3:
                    System.out.println("--------- Delete a Contact --------");
                    System.out.print("Enter ID: ");
                    int delId = Validation.checkID(Validation.sc.next());
                    Contact delContact = manager.getContactById(delId, list);
                    System.out.println(manager.deleteContact(list, delContact) ? "Successful" : "Not found contact");
                    manager.deleteContact(list, delContact);
                    break;
                case 4:
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

}
