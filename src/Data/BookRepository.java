package Data;

import BAO.BAOFactory;
import BAO.BookBAO;
import DTO.BookDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final BookBAO bookBAO = BAOFactory.getBookBAO();

    public static List<BookDTO> loadBooks() {
        List<BookDTO> books;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
            books = (List<BookDTO>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
        return books;
    }

    public static void saveBooks(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            oos.writeObject(bookBAO.listAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}