package GUI;

import DTO.BookDTO;
import utils.ImageUtility;

import javax.swing.*;
import java.awt.Image;
import java.awt.Panel;
import java.util.Objects;

public class DetailPanel {
    private BookDTO book;
    private JPanel detailPanel;
    private JButton goBackButton;
    private JLabel imageLabel;
    private JLabel TitleLabel;
    private JLabel authorLabel;
    private JLabel categoryPanel;
    private JLabel descriptionPanel;
    private JButton buyButton;
    private JSpinner spinner1;
    private JButton borrowButton;
    private JButton restockButton;
    private JButton deleteButton;
    private JButton changeImageButton;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JLabel quantityLabel;
    private JLabel borrowedLabel;

    public DetailPanel(BookDTO book) {
        this.book = book;
    }

    private void createUIComponents() {
        Image image = Objects.requireNonNull(ImageUtility.loadImage("/books/Default_Book_Image.png")).getScaledInstance(240, 330, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(image));
    }

    public JPanel getDetailPanel(){
        return detailPanel;
    }
}
