package DAO;

import DTO.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDAO{
    private List<BookDTO> books =new ArrayList<>();
    public boolean save(BookDTO item) {
        try {
            boolean isExist = false;
            for (int i = 0; i < books.size() ; i++) {
                if (books.get(i).getName().equalsIgnoreCase(item.getName())){
                    isExist = true;
                    books.add(i,item);
                    break;
                }
            }
            if (!isExist)
                books.add(item);
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public void delete(){

    }
    public List<BookDTO> listAll() {
        return books;
    }
}
