package DAO;

import DTO.BookDTO;
import Data.BookRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class BookDaoImp implements BookDAO {

    private static final List<BookDTO> books = BookRepository.loadBooks();

    public boolean save(BookDTO item) {
        int index = getIndex(item.getName());

        if(index == -2) {
            return false;
        } else if (index != -1) {
            books.add(index,item);
        } else
            books.add(item);

        BookRepository.saveBooks();
        return true;
    }

    public boolean delete(String name) {
        int index = getIndex(name);

        if(index < 0)
            return false;
        books.remove(index);

        BookRepository.saveBooks();
        return true;
    }

    public int updateQuantity(int quantity, String name) {
        int index = getIndex(name);
        if(index < 0) return 1; //Error occurred
        BookDTO book = books.get(index);

        if(quantity < 0 && (book.getQuantity() - book.getBorrowed()) < -quantity) return 2; //Quantity not Enough
        book.updateQuantity(quantity);

        BookRepository.saveBooks();
        return 0; //Book borrowed
    }

    public int updateBorrowed(int quantity ,String name) {
        int index = getIndex(name);
        if(index < 0) return 1; //Error occurred
        BookDTO book = books.get(index);

        if(quantity > 0 && (book.getQuantity() - book.getBorrowed() < quantity) || (quantity < 0 && -quantity > book.getBorrowed())) return 2; //Quantity not Enough
        book.updateBorrowed(quantity);

        BookRepository.saveBooks();
        return 0; //Book borrowed
    }

    public int changeImage(String path, String name, String author) {
        int index = getIndex(name);
        if(index < 0) return 1; //Error occurred
        BookDTO book = books.get(index);

        setImage(path, name, author);
        BookRepository.saveBooks();
        return 0;
    }

    private void setImage(String path, String name, String author) {
        File sourceFile = new File(path);
        if (!sourceFile.exists()) {
            return;
        }

        try {
            // Create the destination file in the res folder with the book name
            File destinationFile = new File(new File("res/books"), name + "_" + author + ".png");

            // Copy the file to the destination
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIndex(String name) {
        int index = -1;
        try{
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getName().equalsIgnoreCase(name)) {
                    index = i;
                    break;
                }
            }
        } catch (Exception e){
            return -2;
        }
        return index;
    }

    public List<BookDTO> listAll() {
        return books;
    }

    static {
        for(BookDTO book : books) {
            book.setFirstAdd(false);
        }
    }
}
