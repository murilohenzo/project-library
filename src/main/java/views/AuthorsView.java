package views;

import controllers.AuthorsController;
import models.Authors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthorsView {
    public static void main(String[] args)  throws IOException {
        AuthorsController controller = new AuthorsController();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int option;
        do {
            System.out.println("ID \t\tName \t\tFname");
            controller.getAll().forEach((authors) -> {
                System.out.println(authors.author_id + " \t" + authors.name + "\t\t" + authors.fname);
            });

            System.out.println("1 - Insert \n2 - Update \n3 - Delete \n0 - Exit");
            option = Integer.parseInt(keyboard.readLine());
            if (option == 1) {
                Authors authors = new Authors();
                System.out.println("Author_ID:");
                authors.author_id = Integer.parseInt(keyboard.readLine());
                System.out.println("Name:");
                authors.name = keyboard.readLine();
                System.out.println("Fname:");
                authors.fname = keyboard.readLine();
                controller.insert(authors);
            }
            if (option == 2) {
                Authors authors = new Authors();
                System.out.println("Name:");
                authors.name = keyboard.readLine();
                System.out.println("Fname:");
                authors.fname = keyboard.readLine();
                System.out.println("Author_ID:");
                authors.author_id = Integer.parseInt(keyboard.readLine());
                controller.update(authors);
            }
            if (option == 3) {
                System.out.println("ID:");
                controller.delete(new Integer(keyboard.readLine()));
            }

        }while (option != 0);
    }
}
