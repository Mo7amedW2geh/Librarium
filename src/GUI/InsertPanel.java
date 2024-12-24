package GUI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertPanel extends JPanel {
    private BooksPanel booksPanel;

    public InsertPanel(BooksPanel booksPanel) {
        this.booksPanel = booksPanel;
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(160, 220));
        this.setBackground(Color.gray);

        JLabel Image = new JLabel(new ImageIcon(Assets.addBookImage));
        Image.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> new InsertWindow(booksPanel).display());
            }
        });


        JLabel text = new JLabel("Insert a book", SwingConstants.CENTER);
        text.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        this.add(Image, BorderLayout.CENTER);
        this.add(text, BorderLayout.SOUTH);
    }

}
