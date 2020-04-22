package views;

import controllers.PublishersController;
import models.Publishers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PublishersView {
    public static void main(String[] args)  throws IOException {
        PublishersController controller = new PublishersController();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int option;
        do {
            System.out.println("Publisher_ID \t\tName \t\tUrl");
            controller.getAll().forEach((publishers) -> {
                System.out.println(publishers.publisher_id + " \t" + publishers.name + "\t\t" + publishers.url);
            });

            System.out.println("1 - Insert \n2 - Update \n3 - Delete \n0 - Exit");
            option = Integer.parseInt(keyboard.readLine());
            if (option == 1) {
                Publishers publisher = new Publishers();
                System.out.println("Publisher_ID:");
                publisher.publisher_id = Integer.parseInt(keyboard.readLine());
                System.out.println("Name:");
                publisher.name = keyboard.readLine();
                System.out.println("Url:");
                publisher.url = keyboard.readLine();
                controller.insert(publisher);
            }
            if (option == 2) {
                Publishers publisher = new Publishers();
                System.out.println("Name:");
                publisher.name = keyboard.readLine();
                System.out.println("Url:");
                publisher.url = keyboard.readLine();
                System.out.println("Publisher_ID:");
                publisher.publisher_id = Integer.parseInt(keyboard.readLine());
                controller.update(publisher);
            }
            if (option == 3) {
                System.out.println("Publisher_ID:");
                controller.delete(new Integer(keyboard.readLine()));
            }

        }while (option != 0);
    }
}
