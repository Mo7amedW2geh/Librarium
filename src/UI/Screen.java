package UI;

import core.Book;
import core.Data;
import input.MouseManager;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import static UI.Assets.*;

public class Screen {
    //Screen Settings
    public static final int screenWidth = 940;
    public static final int screenHeight= 540;
    public static final int FPS = 60;

    //Screen Objects
    private Book currentBook = null;
    private MouseManager mouseManager;

    public Screen(MouseManager mouseManager){
        this.mouseManager = mouseManager;
    }


    public void draw(Graphics2D g2d){
        if(currentBook == null) {
            int count = 0;
            for(ArrayList<Book> value : Data.books.values()){
                for(Book book : value){
                    int col = count % 7, row = count / 7;
                    int x = 20 + (130 * col), y = 50 + (160 * row), width = 120, height = 150;

                    g2d.drawImage(book.getImage(), x, y, width, height, null);
                    count++;
                }
            }
        } else {
            g2d.drawImage(back_arrow, 20, 20, 30, 30, null);
            g2d.drawImage(currentBook.getImage(), 40, 60, null);

            g2d.setColor(Color.white);
            g2d.setFont(Arial_B30);
            g2d.drawString(currentBook.getName(), 320, 100);

            g2d.setFont(Arial_14);
            g2d.drawString(currentBook.getDescription(), 320, 140);
        }
    }

    public void update(){

        if(mouseManager.isLeftPressed() && currentBook == null){
            int mouseX = mouseManager.getMouseX();
            int mouseY = mouseManager.getMouseY();

            int count = 0;
            for (ArrayList<Book> value : Data.books.values()) {
                for (Book book : value) {
                    int col = count % 7, row = count / 7;
                    int x = 20 + (130 * col), y = 50 + (160 * row), width = 120, height = 150;

                    // Check if the mouse click is within this book's bounds
                    if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                        currentBook = book;
                    }

                    count++;
                }
            }
        }else if(mouseManager.isLeftPressed() && currentBook != null){
            int mouseX = mouseManager.getMouseX();
            int mouseY = mouseManager.getMouseY();

            if (mouseX >= 20 && mouseX <= 50 && mouseY >= 20 && mouseY <= 50) {
                currentBook = null;
            }
        }

    }

    public void setBook(Book book){
        currentBook = book;
    }

}
