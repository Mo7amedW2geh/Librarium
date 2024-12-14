package old.core;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    public static HashMap<String, ArrayList<Book>> books = new HashMap<>();

    // Load books from file
    public static void loadBooksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("oldBooks.dat"))) {
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oldBooks.dat"))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load default books (initial setup if no file exists)
    private static void loadDefaultBooks() {
        new Book("Book1", "Mystery", "des", 14, "/books/Book1.png");
        new Book("Book2", "Mystery", "des", 9, "/books/Book2.png");
        new Book("Get in Trouble", "Fantasy", "A collection of short stories in which a writer with a fertile and often fabulist imagination", 7, "/books/Book3.png");
        new Book("Book4", "Fantasy", "des", 11, "/books/Book4.png");
        new Book("Book5", "Fantasy", "des", 30);
        new Book("Book6", "Fantasy", "des", 22);
        new Book("Book7", "Fantasy", "des", 13);
        new Book("Book8", "Fantasy", "des", 26);
        new Book("Book9", "Fantasy", "des", 18);
        saveBooksToFile(); // Save defaults on first run
    }

}
