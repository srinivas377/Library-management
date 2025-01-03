package com.library;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        manager.addBook(new Book(title, author, isbn));
                        System.out.println("Book added successfully!");
                        break;

                    case 2:
                        List<Book> books = manager.viewBooks();
                        if (books.isEmpty()) {
                            System.out.println("No books available.");
                        } else {
                            books.forEach(System.out::println);
                        }
                        break;

                    case 3:
                        System.out.print("Enter ISBN of the book to remove: ");
                        String isbnToRemove = scanner.nextLine();
                        manager.removeBook(isbnToRemove);
                        System.out.println("Book removed successfully!");
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
