package GUI;

import DTO.BookDTO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BooksPanel extends JPanel {
    private final InsertPanel insertPanel = new InsertPanel();
    private final List<BookDTO> books;

    public BooksPanel(List<BookDTO> books) {
        this.books = books;
        initialize();
    }

    private void initialize() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.add(insertPanel);

        for(BookDTO b : books){
            Image image = b.getImage().getScaledInstance(160, 220, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(image));
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
