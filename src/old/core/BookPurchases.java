package old.core;

import javax.swing.JOptionPane;

public class BookPurchases implements Purchases {
    private Book book;

    public BookPurchases(Book book){
        this.book = book;
    }

    @Override
    public int getQuantity() {
        return book.quantity;
    }

    @Override
    public int getBorrowed() {
        return book.borrowed;
    }

    @Override
    public void buy(int quantity) {
        if(checkQuantity(quantity))
            book.quantity -= quantity;
        else
            JOptionPane.showMessageDialog(null, "There is no enough quantity");

        Data.saveBooksToFile();
    }

    @Override
    public void borrow() {
        if(checkQuantity(1))
            book.borrowed++;
        else
            JOptionPane.showMessageDialog(null, "There is no enough quantity");

        Data.saveBooksToFile();
    }

    @Override
    public void returnBook() {
        if(book.borrowed > 0)
            book.borrowed--;
        else
            JOptionPane.showMessageDialog(null, "There is no borrowed books");
    }

    private boolean checkQuantity(int quantity){
        return quantity <= book.quantity - book.borrowed;
    }
}
