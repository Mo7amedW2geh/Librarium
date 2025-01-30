package GUI;

import DTO.BookDTO;
import utils.ImageUtility;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class DetailPanel {
    private final MainWindow window;
    private BookDTO book;
    private JPanel detailPanel;
    private JPanel booksPanel;
    private JLabel imageLabel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel categoryPanel;
    private JButton buyButton;
    private JSpinner buySpinner;
    private JButton borrowButton;
    private JButton restockButton;
    private JSpinner borrowSpinner;
    private JSpinner restockSpinner;
    private JLabel quantityLabel;
    private JLabel borrowedLabel;
    private JSpinner returnSpinner;
    private JButton returnButton;
    private JLabel backIconButton;
    private JLabel deleteButton;
    private JTextArea descriptionArea;

    public DetailPanel(MainWindow window, JPanel booksPanel) {
        this.window = window;
        this.booksPanel = booksPanel;
        initialize();
    }

    private void initialize() {

        assert backIconButton != null;
        backIconButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                window.showBooksPanel();
            }
        });

        assert buyButton != null;
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.bookBAO.buy((int) buySpinner.getValue(), book.getName()) == 2)
                    JOptionPane.showMessageDialog(null, "The quantity is not enough", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                quantityLabel.setText("Quantity: " + book.getQuantity());

            }
        });

        assert borrowButton != null;
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.bookBAO.borrow((int) borrowSpinner.getValue(), book.getName()) == 2)
                    JOptionPane.showMessageDialog(null, "The quantity is not enough", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                borrowedLabel.setText("Borrowed: " + book.getBorrowed());
            }
        });

        assert returnButton != null;
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.bookBAO.returnBook((int) returnSpinner.getValue(), book.getName()) == 2)
                    JOptionPane.showMessageDialog(null, "No Borrowed quantity", "Invalid Input", JOptionPane.ERROR_MESSAGE);
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

        assert deleteButton != null;
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(detailPanel, "Are you sure you want to delete \"" + book.getName() + "\"?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION) {
                    booksPanel.remove(window.bookBAO.getIndex(book.getName()) + 1);
                    window.bookBAO.delete(book.getName());
                    window.showBooksPanel();
                }
            }
        });
    }

    private void createUIComponents() {
        Image image = Objects.requireNonNull(ImageUtility.loadImage("/books/Default_Book_Image.png")).getScaledInstance(240, 330, Image.SCALE_SMOOTH);
        Image goBackImage = Objects.requireNonNull(ImageUtility.loadImage("/UI/arrow.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Image deleteImage = Objects.requireNonNull(ImageUtility.loadImage("/UI/delete.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(image));
        backIconButton = new JLabel(new ImageIcon(goBackImage));
        deleteButton = new JLabel(new ImageIcon(deleteImage));

        buySpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        borrowSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        returnSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        restockSpinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
    }

    public JPanel getDetailPanel(){
        return detailPanel;
    }

    public void setBook(BookDTO book){
        this.book = book;

        Image image = (book.isFirstAdd()) ? new ImageIcon(book.getNewImagePath()).getImage() : book.getImage();
        imageLabel.setIcon(new ImageIcon(image.getScaledInstance(240, 330, Image.SCALE_SMOOTH)));
        titleLabel.setText(book.getName());
        authorLabel.setText("Author: \"" + book.getAuthor() + "\"");
        categoryPanel.setText("Category: \"" + book.getCategory() + "\"");
        descriptionArea.setText(book.getDescription());
        quantityLabel.setText("Quantity: " + book.getQuantity());
        borrowedLabel.setText("Borrowed: " + book.getBorrowed());
    }
}
