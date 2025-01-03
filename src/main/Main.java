package main;

import controller.LibraryController;
import view.LibraryView;
import model.Book;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryView view = new LibraryView();
        LibraryController controller = new LibraryController(view);

        controller.addBook(new Book("Java Programming", "John Doe", "123-456"));
        controller.addBook(new Book("Data Structures", "Jane Smith", "789-012"));
        controller.addBook(new Book("Algorithms", "Alan Turing", "345-678"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    controller.addBook(view.getBookDetails());
                    break;
                case 2:
                    controller.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book to edit: ");
                    String editTitle = scanner.nextLine();
                    controller.editBook(editTitle, view.getBookDetails());
                    break;
                case 4:
                    System.out.print("Enter the title of the book to delete: ");
                    String deleteTitle = scanner.nextLine();
                    controller.deleteBook(deleteTitle);
                    break;
                case 5:
                    String searchCriteria = view.getSearchCriteria();
                    controller.searchBook(searchCriteria);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
