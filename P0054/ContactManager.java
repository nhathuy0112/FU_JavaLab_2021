package P0054;

import java.util.List;

public class ContactManager {

    public Contact getNewContact(int id) {
        System.out.println("--------- Add a Contact ---------");
        Validation.sc.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = Validation.checkInputString("First Name");
        System.out.print("Enter Last Name: ");
        String lastName = Validation.checkInputString("Last Name");
        System.out.print("Enter Group: ");
        String group = Validation.checkInputString("Group");
        System.out.print("Enter Address: ");
        String address = Validation.checkInputString("Address");
        System.out.print("Enter Phone: ");
        String phone = Validation.checkInputPhone();
        return new Contact(id, firstName, lastName, group, address, phone);
    }

    public boolean addContact(List<Contact> list, Contact contact) {
        if (list.contains(contact))
            return false;
        list.add(contact);
        return true;
    }

    public void displayAll(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("List of contacts is empty");
            return;
        }
        System.out.printf("%-10s%-40s%-20s%-20s%-15s%-15s%-30s\n", "ID", "Name", "First Name", "Last Name", "Group",
                "Address", "Phone");
        for (Contact contact : list) {
            System.out.println(contact.toString());
        }
    }

    public Contact getContactById(int id, List<Contact> list) {
        for (Contact contact : list) {
            if (contact.getId() == id)
                return contact;
        }
        return null;
    }

    public boolean deleteContact(List<Contact> list, Contact contact) {
        if (!list.contains(contact) || contact == null)
            return false;
        list.remove(contact);
        return true;
    }
}
