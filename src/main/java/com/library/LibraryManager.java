package com.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private static final String FILE_NAME = "library.txt";

    public void addBook(Book book) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getIsbn());
            writer.newLine();
        }
    }

    public List<Book> viewBooks() throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    books.add(new Book(parts[0], parts[1], parts[2]));
                }
            }
        }
        return books;
    }

    public void removeBook(String isbn) throws IOException {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("library_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && !parts[2].equals(isbn)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }

        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            throw new IOException("Failed to update the file");
        }
    }
}
