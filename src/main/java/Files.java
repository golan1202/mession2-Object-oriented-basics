import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Files {

    public  void writeToFile(String path, PhoneBook phoneBook) {
        try {
            FileWriter myWriter = new FileWriter(path);
            for (Contact contact: phoneBook.bookPhone)
                myWriter.write(contact.getName() +"," + contact.getPhone() +"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public  PhoneBook readFromFile(String path) {
        PhoneBook bookPhone = new PhoneBook();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                bookPhone.addContact(parts[0],  parts[1]);
            }
            myReader.close();
            return bookPhone;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return bookPhone;
    }

    public static void main(String[] args) {
        Files files = new Files();
        PhoneBook phoneBook = files.readFromFile("C:\\Users\\golan\\Desktop\\Mession2\\src\\main\\resources\\file1.txt");
        phoneBook.printPhoneBook();
        files.writeToFile("C:\\Users\\golan\\Desktop\\Mession2\\src\\main\\resources\\file2.txt", phoneBook);

    }
}
