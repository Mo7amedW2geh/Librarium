package core;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    public static HashMap<String, ArrayList<Book>> books = new HashMap<>();

    // Load books from file
    public static void loadBooksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
            books = (HashMap < String, ArrayList < Book >>) ois.readObject();
            for(ArrayList<Book> value : books.values()){
                for(Book book : value){
                    book.setImage(book.getImagePath());
                }
            }
            System.out.println("Books loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No books file found. Loading defaults.");
            loadDefaultBooks();
        }
    }

    // Save books to file
    public static void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            oos.writeObject(books);
            System.out.println("Books saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load default books (initial setup if no file exists)
    private static void loadDefaultBooks() {
        new Book("Book1", "Mystery", "des", 7, "/books/Book1.png");
        new Book("Book2", "Mystery", "des", 7, "/books/Book2.png");
        new Book("Get in Trouble", "Fantasy", "A collection of short stories in which a writer with a fertile and often fabulist imagination", 7, "/books/Book3.png");
        new Book("Book4", "Fantasy", "des", 7, "/books/Book4.png");
        new Book("Book5", "Fantasy", "des", 7);
        new Book("Book6", "Fantasy", "des", 7);
        new Book("Book7", "Fantasy", "des", 7);
        new Book("Book8", "Fantasy", "des", 7);
        new Book("Book9", "Fantasy", "des", 7);
        saveBooksToFile(); // Save defaults on first run
    }

}
