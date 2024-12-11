package GUI;

import javax.swing.JFrame;

public class MainWindow {
    private JFrame window;

    public MainWindow(){
        initialize();
    }

    private void initialize(){
        window = new JFrame("Main Window");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(960, 540);
        window.setLocationRelativeTo(null);


    }

    public void show(){
        window.setVisible(true);
    }
}
