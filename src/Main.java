
public class Main {
    public static void main(String[] args) {
        Display screen = new Display("test", 960, 540);
    }

    static {
        new Book("Book1", "Mystery", "des", 7, "/books/Book1.png");
        new Book("Book2", "Mystery", "des", 7, "/books/Book2.png");
        new Book("Book3", "Fantasy", "des", 7, "/books/Book3.png");
        new Book("Book4", "Fantasy", "des", 7, "/books/Book4.png");
        new Book("Book5", "Fantasy", "des", 7);
        new Book("Book6", "Fantasy", "des", 7);
        new Book("Book7", "Fantasy", "des", 7);
        new Book("Book8", "Fantasy", "des", 7);
        new Book("Book9", "Fantasy", "des", 7);
    }
}