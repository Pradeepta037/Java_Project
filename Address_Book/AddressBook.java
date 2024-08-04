public class AddressBook {
    private Contact[] contacts;
    private int count;

    // Constructor
    public AddressBook(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (count >= contacts.length) {
            System.out.println("Address book is full. Cannot add more contacts.");
            return;
        }
        contacts[count] = contact;
        count++;
    }

    // Edit a contact by name
    public boolean editContact(String name, String newPhoneNumber, String newEmail) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equals(name)) {
                contacts[i].setPhoneNumber(newPhoneNumber);
                contacts[i].setEmail(newEmail);
                return true;
            }
        }
        return false;
    }

    // Search for a contact by name
    public Contact searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equals(name)) {
                return contacts[i];
            }
        }
        return null;
    }

    // Display all contacts
    public void displayAllContacts() {
        if (count == 0) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(contacts[i]);
        }
    }
}
