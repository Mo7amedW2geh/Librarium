import java.awt.image.BufferedImage;

public class Book {

    private final String name;
    private final String category;
    private String description;
    private int quantity;

    BufferedImage image;

    BufferedImage defaultImage = ImageUtility.loadImage("books/Default_Book_Image.png");

    public Book(String name, String category, int quantity){
        this.name = name;
        this.category = category;
        this.quantity = quantity;

        assert defaultImage != null;
        image = ImageUtility.scaleImage(defaultImage, 120, 150);
    }

    public Book(String name, String category, int quantity, String description){
        this(name, category, quantity);
        this.description = description;
    }



    //Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(BufferedImage image) {
        assert defaultImage != null;
        this.image = ImageUtility.scaleImage(image, 120, 150);
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
