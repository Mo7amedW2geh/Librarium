
public class Main {
    public static void main(String[] args) {
        Display screen = new Display("test", 960, 540);
    }

    static {
        Book book1 = new Book("Book1", "Mystery", "des", 7, "/books/Book1.png");
        Book book2 = new Book("Book2", "Mystery", "des", 7, "/books/Book2.png");
        Book book3 = new Book("Book3", "Fantasy", "des", 7, "/books/Book3.png");
        Book book4 = new Book("Book4", "Fantasy", "des", 7, "/books/Book4.png");
        Book book5 = new Book("Book5", "Fantasy", "des", 7);
        Book book6 = new Book("Book6", "Fantasy", "des", 7);
        Book book7 = new Book("Book7", "Fantasy", "des", 7);
        Book book8 = new Book("Book8", "Fantasy", "des", 7);
        Book book9 = new Book("Book9", "Fantasy", "des", 7);
    }
}