package DAO;

import DTO.BookDTO;

import java.util.List;

public interface BookDAO {
    boolean save(BookDTO item);
    boolean delete(String name);
    int updateQuantity(int quantity, String name);
    int updateBorrowed(int quantity ,String name);
    int changeImage(String path, String name, String author);
    int getIndex(String name);
    List<BookDTO> listAll();
}
