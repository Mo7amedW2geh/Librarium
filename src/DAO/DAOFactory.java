package DAO;

public class DAOFactory {
    public static BookDAO getBookDAO() {
        return new BookDaoImp();
    }
}
