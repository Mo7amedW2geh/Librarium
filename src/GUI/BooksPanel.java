package GUI;

import DTO.BookDTO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class BooksPanel extends JPanel {
    private final InsertPanel insertPanel = new InsertPanel();
    private List<BookDTO> books;

    public BooksPanel(List<BookDTO> books) {
        this.books = books;
        initialize();
    }

    private void initialize() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.add(insertPanel);

        for(BookDTO b : books){
            JLabel label = new JLabel(new ImageIcon(b.getImage()));
            label.setToolTipText(b.getName());

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Open " + b.getName());
                }
            });

            this.add(label);
        }

    }
}
