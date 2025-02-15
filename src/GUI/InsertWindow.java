package GUI;

import BAO.BAOFactory;
import BAO.BookBAO;
import BAO.BookBaoImp;
import DTO.BookDTO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class InsertWindow extends JDialog {
    private BooksPanel booksPanel;
    private final BookBAO bookBAO = BAOFactory.getBookBAO();
    private JPanel window;
    private JTextField titleField;
    private JTextField authorField;
    private JComboBox<String> categoryComboBox;
    private JSpinner quantitySpinner;
    private JTextArea descriptionArea;
    private JButton insertButton;
    private JScrollPane descriptionScrollPane;
    private JButton selectImageButton;
    private JLabel imageLabel;
    private String imagePath;

    public InsertWindow(BooksPanel booksPanel) {
        super((JFrame) null, "Insert Window", true);
        this.booksPanel = booksPanel;
        this.setContentPane(window);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 360);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        initialize();
    }

    private void initialize() {


        selectImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));
                int returnValue = fileChooser.showOpenDialog(InsertWindow.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    imagePath = fileChooser.getSelectedFile().getAbsolutePath();

                    Image image = new ImageIcon(imagePath).getImage().getScaledInstance(100, 138, Image.SCALE_SMOOTH);


                    if (imagePath.endsWith(".jpg") || imagePath.endsWith(".jpeg") || imagePath.endsWith(".png") || imagePath.endsWith(".gif")) {
                        imageLabel.setIcon(new ImageIcon(image));  // Set selected image to the label
                        imageLabel.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a valid image file.", "Invalid File", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = titleField.getText();
                String author = authorField.getText();
                String category = (String) categoryComboBox.getSelectedItem();
                int quantity = (Integer) quantitySpinner.getValue();
                String description = descriptionArea.getText();

                if(title.trim().isEmpty() || author.trim().isEmpty() || description.trim().isEmpty() || Objects.equals(category, "Select Category")) {
                    JOptionPane.showMessageDialog(null, "Please insert a valid input.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                BookDTO book = new BookDTO(title, author, category, description, quantity);
                bookBAO.insert(book);

                if(imagePath != null) {
                    book.setFirstAdd(true);
                    bookBAO.changeImage(imagePath ,title, author);
                    book.setNewImagePath(imagePath);
                }


                booksPanel.insertBook(book, (imagePath == null) ? null : new ImageIcon(imagePath)); //check image inserted or not
                booksPanel.revalidate();
                booksPanel.repaint();

                dispose();
            }
        });


    }


    private void createUIComponents() {
        //Quantity
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));

    }

    public void display() {
        this.setVisible(true);
    }
}
