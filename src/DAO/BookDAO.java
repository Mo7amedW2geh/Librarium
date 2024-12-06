package DAO;

import DTO.BookDTO;

import java.util.List;

public interface BookDAO {
    boolean save(BookDTO item);
    void delete();
    List<BookDTO> listAll();
}
