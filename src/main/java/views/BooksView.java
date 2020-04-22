package views;

import controllers.BooksController;
import models.Books;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooksView {
    public static void main(String[] args)  throws IOException {
        BooksController controller = new BooksController();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int option;
        do {
            System.out.println("1 - Insert \n2 - Update \n3 - Delete \n4 - Search \n5 - Listar \n0 - Exit");
            option = Integer.parseInt(keyboard.readLine());
            if (option == 1) {
                Books books = new Books();
                System.out.println("Title:");
                books.title = keyboard.readLine();
                System.out.println("ISBN:");
                books.isbn = keyboard.readLine();
                System.out.println("Publisher_ID:");
                books.publisher_id = Integer.parseInt(keyboard.readLine());
                System.out.println("Price:");
                books.price = Float.parseFloat(keyboard.readLine());
                controller.insert(books);
            }
            if (option == 2) {
                Books books = new Books();
                System.out.println("Title:");
                books.title = keyboard.readLine();
                System.out.println("Publisher_ID:");
                books.price = Integer.parseInt(keyboard.readLine());
                System.out.println("Price:");
                books.price = Float.parseFloat(keyboard.readLine());
                System.out.println("ISBN:");
                books.isbn = keyboard.readLine();
                controller.update(books);
            }
            if (option == 3) {
                System.out.println("ISBN:");
                controller.delete(new String(keyboard.readLine()));
            }
            if (option == 4) {
                System.out.println("Search Books");
                controller.search(new String(keyboard.readLine())).forEach((books) -> {
                    System.out.println(books.title + " ==> " + books.author_name + " ==> " + books.author_fname
                            + " ==> " + books.publisher_name + " ==> $" + books.price);
                });
            }
            if (option == 5) {
                System.out.println("Title \t\tISBN \t\tPublisher_ID \t\tPrice");
                controller.getAll().forEach((books) -> {
                    System.out.println(books.title + " ==> " + books.isbn + " ==> " + books.publisher_id
                            + " ==> $" + books.price);
                });
            }

        }while (option != 0);
    }
}
