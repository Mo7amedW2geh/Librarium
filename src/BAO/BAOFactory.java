package BAO;

public class BAOFactory {
    public BookBAO getBookBAO(){
        return new BookBaoImp();
    }
}
