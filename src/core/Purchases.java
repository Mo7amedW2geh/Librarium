package core;

public interface Purchases {

    public int getQuantity();
    public int getBorrowed();

    public void buy(int quantity);
    public void borrow();
    public void returnBook();
}

