package GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertWindow extends JFrame {

    private JTextField titleField;
    private JTextArea descriptionArea;
    private JTextField authorField;
    private JTextField categoryField;
    private JLabel imageLabel;
    private JComboBox categoryComboBox;
    private JSpinner quantitySpinner;

    public InsertWindow() {
        this.setTitle("Insert Window");
        this.setContentPane(new InsertWindow1().getWindow());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 280);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(new FlowLayout(FlowLayout.LEFT));

        //initialize();
    }

    private void initialize() {
        // Title Field
        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20); // 20 columns wide
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);

        // Author Field
        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);
        JPanel authorPanel = new JPanel();
        authorPanel.add(authorLabel);
        authorPanel.add(authorField);

        // Category Field
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = { "Fiction", "Non-Fiction", "Science", "History", "Technology" };
        categoryComboBox = new JComboBox<>(categories);
        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryComboBox);

        // Quantity Field
        JLabel quantityLabel = new JLabel("Quantity:");
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) quantitySpinner.getEditor();
        editor.getTextField().setColumns(5);
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantitySpinner);


        // Description Field (multiline)
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(4, 20); // 4 rows and 20 columns
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionScrollPane);


        // Image Label (for showing the selected image)
        JLabel imageLabel = new JLabel("No image selected");
        imageLabel.setPreferredSize(new Dimension(100, 100)); // Adjust size of the image preview
        imageLabel.setBackground(Color.LIGHT_GRAY);
        imageLabel.setOpaque(true);

        // Browse Button for selecting an image
        JButton browseButton = new JButton("Browse Image");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(InsertWindow.this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
                    imageLabel.setIcon(new ImageIcon(selectedImagePath));  // Set selected image to the label
                    imageLabel.setText("");  // Clear the default text
                }
            }
        });

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // You can handle the form submission here
                String title = titleField.getText();
                String description = descriptionArea.getText();
                String author = authorField.getText();
                String category = categoryField.getText();
                // Process the information (e.g., save it, or display a message)
                System.out.println("Book Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Author: " + author);
                System.out.println("Category: " + category);
            }
        });

        // Add all components to the window
        this.add(titlePanel);
        this.add(authorPanel);
        this.add(categoryPanel);
        this.add(quantityPanel);
        this.add(descriptionPanel);
        this.add(imageLabel);
        this.add(browseButton);
        this.add(submitButton);
    }

    public void display() {
        this.setVisible(true);
    }
}
