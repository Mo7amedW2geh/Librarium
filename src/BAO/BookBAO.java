package BAO;

import DAO.BookDAO;
import DTO.BookDTO;

import java.util.List;

public interface BookBAO {

    boolean insert(BookDTO book);
    int buy(int quantity, String name);
    int borrow(int quantity, String name);
    int reStock(int quantity, String name);
    int returnBook(int quantity, String name);
    int getIndex(String name);
    boolean delete(String name);
    void changeImage(String path ,String name, String author);
    List<BookDTO> listAll();

}
