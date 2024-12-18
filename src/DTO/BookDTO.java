package DTO;

import utils.ImageUtility;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class BookDTO {

    private String name, description, author, category;
    private int quantity, borrowed;



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

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void updateBorrowed(int borrowed) {
        this.borrowed += borrowed;
    }

    public BufferedImage getImage() {
        BufferedImage cover = ImageUtility.loadImage(name + ".png");
        if(cover == null) return ImageUtility.loadImage("Default_Book_Image.png");
        return cover;
    }
}
