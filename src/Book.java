import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Book {

    private final String name;
    private final String category;
    private final String description;
    private int quantity;
    public static HashMap<String, ArrayList<Book>> books = new HashMap<>();

    BufferedImage image;

    BufferedImage defaultImage = ImageUtility.loadImage("books/Default_Book_Image.png");

    public Book(String name, String category, String description, int quantity){
        this.name = name;
        this.category = category.toLowerCase();
        this.quantity = quantity;
        this.description = description;
        if(books.containsKey(category))
            books.get(category).add(this);
        else {
            ArrayList<Book> book = new ArrayList<>();
            book.add(this);
            books.put(category, book);
        }

        assert defaultImage != null;
        image = ImageUtility.scaleImage(defaultImage, 120, 150);
    }

    public Book(String name, String category, String description, int quantity, String path){
        this(name, category, description, quantity);
        BufferedImage image = ImageUtility.loadImage(path);

        assert image != null;
        this.image = ImageUtility.scaleImage(image, 120, 150);
    }



    //Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BufferedImage getImage() {
        return image;
    }
}
