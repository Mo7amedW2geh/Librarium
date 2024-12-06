package BAO;

import DAO.BookDAO;
import DTO.BookDTO;

import java.util.List;

public interface BookBAO {

    void insert(BookDAO book);
    void buy(int quantity);
    void borrow();
    void reStock(int quantity);
    void delete();
    void changeImage();
    List<BookDTO> listAll();

}
