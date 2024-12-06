package BAO;

import DAO.BookDAO;
import DAO.DAOFactory;
import DTO.BookDTO;

import java.util.List;

public class BookBaoImp implements BookBAO{
    private BookDAO bookDAO = new DAOFactory().getBookDAO();
    public void insert(BookDAO book) {

    }

    public void buy(int quantity) {

    }

    public void borrow() {

    }

    public void reStock(int quantity) {

    }

    public void delete() {

    }

    public void changeImage() {

    }

    public List<BookDTO> listAll() {
        return List.of();
    }
}
