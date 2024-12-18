package GUI;

import javax.swing.*;

public class InsertWindow1 {
    private JPanel window;
    private JTextField titleField;
    private JTextField authorField;
    private JComboBox descriptionComboBox;
    private JSpinner quantitySpinner;
    private JTextArea descriptionArea;
    private JButton insertButton;
    private JScrollPane descriptionScrollPane;

    public JPanel getWindow() {
        return window;
    }

    private void createUIComponents() {

        //Quantity
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1));

    }
}
