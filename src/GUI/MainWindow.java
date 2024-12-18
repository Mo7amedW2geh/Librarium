package GUI;

import BAO.BAOFactory;
import BAO.BookBAO;
import DTO.BookDTO;

import javax.swing.*;
import java.awt.CardLayout;

public class MainWindow {
    private final BookBAO bookBAO = BAOFactory.getBookBAO();
    private JFrame window;
    private BooksPanel booksPanel;

    public MainWindow(){
        initialize();
    }

    private void initialize(){
        window = new JFrame("Main Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(960, 540);
        window.setLocationRelativeTo(null);
        window.setLayout(new CardLayout());

        booksPanel = new BooksPanel(bookBAO.listAll());

        JScrollPane scrollPane = new JScrollPane(booksPanel);

        window.add(scrollPane);
    }

    public void show(){
        window.setVisible(true);
    }
}
