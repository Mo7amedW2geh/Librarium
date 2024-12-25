package DTO;

import utils.ImageUtility;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Objects;

public class BookDTO implements Serializable {

    private String name, description, author, category, newImagePath;
    private int quantity, borrowed;
    private boolean firstAdd;


    public BookDTO(){
    }

    public BookDTO(String name, String author, String category, String description, int quantity){
        this.name = name;
        this.author = author;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNewImagePath() {
        return newImagePath;
    }

    public void setNewImagePath(String newImagePath) {
        this.newImagePath = newImagePath;
    }

    public boolean isFirstAdd() {
        return firstAdd;
    }

    public void setFirstAdd(boolean firstAdd) {
        this.firstAdd = firstAdd;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void updateBorrowed(int borrowed) {
        this.borrowed += borrowed;
    }

    public Image getImage() {
        BufferedImage image = ImageUtility.loadImage("/books/" + name + "_" + author + ".png");
        if(image == null) image = ImageUtility.loadImage("/books/Default_Book_Image.png");
        return new ImageIcon(Objects.requireNonNull(image)).getImage();
    }
}
