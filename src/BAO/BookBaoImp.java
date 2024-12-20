package BAO;

import DAO.BookDAO;
import DAO.DAOFactory;
import DTO.BookDTO;

import java.util.List;

public class BookBaoImp implements BookBAO {

    private final BookDAO bookDAO = DAOFactory.getBookDAO();

    public boolean insert(BookDTO book) {
        return bookDAO.save(book);
    }

    public int buy(int quantity, String name) {
        return bookDAO.updateQuantity(-quantity, name);
    }

    public int borrow(int quantity ,String name) {
        return bookDAO.updateBorrowed(quantity, name);
    }

    public int reStock(int quantity, String name) {
        return bookDAO.updateQuantity(quantity, name);
    }

    public boolean delete(String name) {
        return bookDAO.delete(name);
    }

    public void changeImage(String path,String name) {
        bookDAO.changeImage(path, name);
    }

    public List<BookDTO> listAll() {
        return bookDAO.listAll();
    }
}
