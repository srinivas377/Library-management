package view;

import model.Book;
import java.util.List;
import java.util.Scanner;

public class LibraryView {

    public void showMenu() {
        System.out.println("\n1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Edit a Book");
        System.out.println("4. Delete a Book");
        System.out.println("5. Search for a Book");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");
    }

    public Book getBookDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        return new Book(title, author, isbn);
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.displayBookDetails();
                System.out.println("--------------------------");
            }
        }
    }

    public void displayBook(Book book) {
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            book.displayBookDetails();
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getSearchCriteria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search criteria (title/author/isbn): ");
        return scanner.nextLine();
    }
}
