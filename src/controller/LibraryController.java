package controller;

import model.Book;
import view.LibraryView;
import java.util.ArrayList;
import java.util.List;

public class LibraryController {
    private List<Book> books = new ArrayList<>();
    private LibraryView view;

    public LibraryController(LibraryView view) {
        this.view = view;
    }

    public void addBook(Book book) {
        books.add(book);
        view.showMessage("Book added successfully!");
    }

    public void viewBooks() {
        view.displayBooks(books);
    }

    public void editBook(String title, Book updatedBook) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setIsbn(updatedBook.getIsbn());
                view.showMessage("Book details updated successfully!");
                return;
            }
        }
        view.showMessage("Book not found.");
    }

    public void deleteBook(String title) {
        Book bookToDelete = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToDelete = book;
                break;
            }
        }

        if (bookToDelete != null) {
            books.remove(bookToDelete);
            view.showMessage("Book deleted successfully!");
        } else {
            view.showMessage("Book not found.");
        }
    }

    public void searchBook(String criteria) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(criteria) || book.getAuthor().equalsIgnoreCase(criteria) || book.getIsbn().equalsIgnoreCase(criteria)) {
                view.displayBook(book);
                return;
            }
        }
        view.showMessage("No book found matching the criteria.");
    }
}
 						