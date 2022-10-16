import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook  {
    ArrayList<Contact> bookPhone = new ArrayList<Contact>();


    public void addContact(String name, String phone) {
        Contact newContact = new Contact(name, phone);
        bookPhone.add(newContact);
    }

    public void deleteContact(String name) {
        boolean flag = false;
        for(int i=0; i < bookPhone.size(); i++)
            if (bookPhone.get(i).getName().equals(name)) {
                bookPhone.remove(i);
                flag = true;
                break;
        }
        if (flag)
            System.out.println("Contact deleted successfully");
        else
            System.out.println("There is no such contact");
    }

    public void printPhoneBook() {
        System.out.println("--------");
        for (Contact contact: bookPhone)
            System.out.println(contact);
        System.out.println("--------");
    }

    public void searchContact(String name) {
        boolean flag = false;
        for (Contact contact: bookPhone) {
            if (contact.getName().equals(name)) {
                System.out.println(contact.getName() + " " + contact.getPhone());
                flag = true;
            }
        }
        if(!flag)
            System.out.println("There is no such contact");
    }


    public void sortDescByPhone() {
        Collections.sort(bookPhone, (con1, con2) -> con2.getPhone().compareTo(con1.getPhone()));
        printPhoneBook();
    }

    public void sortAscByName() {
        Collections.sort(bookPhone, Comparator.comparing(Contact::getName));
        printPhoneBook();
    }
    public void reversePhoneBookOrder(){
        printPhoneBook();
        Collections.reverse(bookPhone);
        printPhoneBook();
    }

    public void removeDuplicate() {
        Iterator<Contact> itr = bookPhone.iterator();
        if (itr.hasNext())
            itr.next();

        while (itr.hasNext()) {
            Contact contactNext = itr.next();
            if (itr.hasNext() && contactNext.equals(itr.next())) {
                System.out.println(contactNext + " removed");
                itr.remove();
            }
        }
    }

        public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("moshe", "434234");
        phoneBook.addContact("Amit", "3215315");
        phoneBook.addContact("amir", "43223");
        phoneBook.addContact("golan", "66555");
        phoneBook.addContact("golan", "66555");
        phoneBook.addContact("nitzan", "1222223");
        phoneBook.addContact("nitzan", "1222223");
        phoneBook.printPhoneBook();
        phoneBook.removeDuplicate();
        phoneBook.printPhoneBook();
    }
}
