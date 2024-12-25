package GUI;

import BAO.BAOFactory;
import BAO.BookBAO;
import DTO.BookDTO;

import javax.swing.*;
import java.awt.CardLayout;

public class MainWindow {
    final BookBAO bookBAO = BAOFactory.getBookBAO();
    private JFrame window;
    private BooksPanel booksPanel;
    private DetailPanel detailPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    boolean imageFirstAdd;
    String imagePath;

    public MainWindow(){
        initialize();
    }

    private void initialize(){
        window = new JFrame("Main Window");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(890, 540);
        window.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        booksPanel = new BooksPanel(this);
        detailPanel = new DetailPanel(this);

        cardPanel.add(booksPanel, "booksPanel");
        cardPanel.add(detailPanel.getDetailPanel(), "detailPanel");
        cardLayout.show(cardPanel, "booksPanel");

        window.add(cardPanel);
    }

    public void show(){
        window.setVisible(true);
    }

    public void showDetailPanel(BookDTO book) {
        cardLayout.show(cardPanel, "detailPanel");
        detailPanel.setBook(book);
    }

    public void showBooksPanel() {
        cardLayout.show(cardPanel, "booksPanel");
    }
}
