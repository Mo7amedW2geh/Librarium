package GUI;

import DTO.BookDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BooksPanel extends JPanel {
    private final MainWindow window;
    private final InsertPanel insertPanel = new InsertPanel(this);
    private final List<BookDTO> books;
    private final JPanel booksPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));


    public BooksPanel(MainWindow window) {
        this.window = window;
        this.books = window.bookBAO.listAll();
        window.setupDetailPanel(booksPanel);

        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());
        booksPanel.add(insertPanel); //Insert Panel

        //Books
        for(BookDTO b : books){
            insertBook(b, null);
        }

        JScrollPane scrollPane = new JScrollPane(booksPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        this.add(scrollPane);

    }

    void insertBook(BookDTO book, ImageIcon icon){
        Image image = (icon == null) ? book.getImage() : icon.getImage(); //check book is new or not
        JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(160, 220, Image.SCALE_SMOOTH)));
        label.setToolTipText(book.getName());

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.showDetailPanel(book);
            }
        });
        booksPanel.add(label);
        updatePreferredSize();
    }

    private void updatePreferredSize() {
        int rows = (books.size()) / 5 + 1;
        int height = rows * 240;
        booksPanel.setPreferredSize(new Dimension(890, height));
    }
}
