package GUI;

import DTO.BookDTO;
import utils.ImageUtility;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DetailPanel {
    private final MainWindow window;
    private BookDTO book;
    private JPanel detailPanel;
    private JButton goBackButton;
    private JLabel imageLabel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel categoryPanel;
    private JLabel descriptionPanel;
    private JButton buyButton;
    private JSpinner buySpinner;
    private JButton borrowButton;
    private JButton restockButton;
    private JButton deleteButton;
    private JButton changeImageButton;
    private JSpinner borrowSpinner;
    private JSpinner restockSpinner;
    private JLabel quantityLabel;
    private JLabel borrowedLabel;

    public DetailPanel(MainWindow window) {
        this.window = window;
        initialize();

    }

    private void initialize() {

        assert goBackButton != null;
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.showBooksPanel();
            }
        });

        assert buyButton != null;
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.bookBAO.buy((int) buySpinner.getValue(), book.getName());
                quantityLabel.setText("Quantity: " + book.getQuantity());
            }
        });

        assert borrowButton != null;
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.bookBAO.borrow((int) borrowSpinner.getValue(), book.getName());
                borrowedLabel.setText("Borrowed: " + book.getBorrowed());
            }
        });

        assert restockButton != null;
        restockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.bookBAO.reStock((int) restockSpinner.getValue(), book.getName());
                quantityLabel.setText("Quantity: " + book.getQuantity());
            }
        });
    }

    private void createUIComponents() {
        Image image = Objects.requireNonNull(ImageUtility.loadImage("/books/Default_Book_Image.png")).getScaledInstance(240, 330, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(image));

        buySpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        borrowSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        restockSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
    }

    public JPanel getDetailPanel(){
        return detailPanel;
    }

    public void setBook(BookDTO book){
        this.book = book;
        Image image = (window.imageFirstAdd) ? new ImageIcon(window.imagePath).getImage() : book.getImage();
        imageLabel.setIcon(new ImageIcon(image.getScaledInstance(240, 330, Image.SCALE_SMOOTH)));
        titleLabel.setText(book.getName());
        authorLabel.setText("Author: \"" + book.getAuthor() + "\"");
        categoryPanel.setText("Category: \"" + book.getCategory() + "\"");
        descriptionPanel.setText(book.getDescription());
        quantityLabel.setText("Quantity: " + book.getQuantity());
        borrowedLabel.setText("Borrowed: " + book.getBorrowed());
    }
}
