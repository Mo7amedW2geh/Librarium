package BAO;

public class BAOFactory {
    public static BookBAO getBookBAO(){
        return new BookBaoImp();
    }
}
