package DAO;

public class DAOFactory {
    public BookDAO getBookDAO() {
        return new BookDaoImp();
    }
}
