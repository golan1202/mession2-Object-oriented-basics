import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    PhoneBook phoneBook= new PhoneBook();
    Files files= new Files();

    void printMenu() {
        System.out.println("Menu: choose from the list");
        System.out.println("1. Add Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Print Phonebook");
        System.out.println("4. Search Contact");
        System.out.println("5. Sort PhoneBook by name ascending");
        System.out.println("6. Sort PhoneBook by phone descending");
        System.out.println("7. Reverse Phone Book Order");
        System.out.println("8. Remove Duplicates");
        System.out.println("9. Save to a file");
        System.out.println("10. Load to a file");
        System.out.println("11. Exit");

    }
    void addContact() {
        scanner = new Scanner(System.in);
        System.out.println("please enter name");
        String name = scanner.nextLine();
        System.out.println("please enter phone");
        String phone = scanner.nextLine();;
        phoneBook.addContact(name, phone);
    }
    void deleteContact() {
        scanner = new Scanner(System.in);
        System.out.println("please enter name to delete");
        String name = scanner.nextLine();;
        phoneBook.deleteContact(name);
    }
    void searchContact() {
        scanner = new Scanner(System.in);
        System.out.println("please enter name to search for");
        String name = scanner.nextLine();;
        phoneBook.searchContact(name);
    }
    void saveTofile() {
        scanner = new Scanner(System.in);
        System.out.println("please enter path to save the phoneBook");
        String path = scanner.nextLine();
        files.writeToFile(path, phoneBook);
    }
    void loadFromFile() {
        scanner = new Scanner(System.in);
        System.out.println("please enter path to load from file");
        String path = scanner.nextLine();
        phoneBook = files.readFromFile(path);
    }
    void  runProgram(){
        int failures = 0;
        while(failures < 3) {
            printMenu();
            int option = scanner.nextInt();
            if (option < 1 || option > 11) {
                failures++;
                System.out.println("incorrect input");
            } else {
                switch (option) {
                    case 1 -> addContact();
                    case 2 -> deleteContact();
                    case 3 -> phoneBook.printPhoneBook();
                    case 4 -> searchContact();
                    case 5 -> phoneBook.sortAscByName();
                    case 6 -> phoneBook.sortDescByPhone();
                    case 7 -> phoneBook.reversePhoneBookOrder();
                    case 8 -> phoneBook.removeDuplicate();
                    case 9 -> saveTofile();
                    case 10 -> loadFromFile();
                    case 11 -> System.exit(0);
                }
            }
        }

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.runProgram();
    }
}
