package core;

import utils.ImageUtility;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Book implements Serializable {

    private final String name;
    private final String category;
    private final String description;
    private int quantity;

    private String imagePath;
    private transient BufferedImage image;

    public static HashMap<String, ArrayList<Book>> books = new HashMap<>();

    public Book(String name, String category, String description, int quantity){
        this.name = name;
        this.category = category.toLowerCase();
        this.quantity = quantity;
        this.description = description;

        // Add book to the category list
        Data.books.computeIfAbsent(category, k -> new ArrayList<>()).add(this);

        // Set default image if image not specified
        setImage("/books/Default_Book_Image.png");
    }

    public Book(String name, String category, String description, int quantity, String path){
        this(name, category, description, quantity);
        setImage(path);
    }

    //Setters
    public void setImage(String path){
        imagePath = path;
        BufferedImage image = ImageUtility.loadImage(path);

        assert image != null;
        this.image = ImageUtility.scaleImage(image, 240, 300);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Getters
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getImagePath() { return imagePath; }
    public int getQuantity() { return quantity; }
    public BufferedImage getImage() { return image; }

}
