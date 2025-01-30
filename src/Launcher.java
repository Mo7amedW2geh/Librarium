import GUI.MainWindow;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            MainWindow main = new MainWindow();
            main.show();
        });
    }
}
