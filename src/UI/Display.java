package UI;

import core.Book;
import core.Data;
import core.Main;
import input.MouseManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JPanel{

    private final Main main;
    private final String title;
    private final int screenWidth;
    private final int screenHeight;


    public MouseManager mouseManager = new MouseManager();

    public Display(String title, int width, int height, Main main){
        this.title = title;
        this.screenWidth = width;
        this.screenHeight = height;
        this.main = main;

        createDisplay();
    }

    public void createDisplay(){
        JFrame window = new JFrame(title);
        window.setSize(screenWidth, screenHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(43, 45, 48));
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        //button test
//        JButton button = new JButton("here");
//        button.setBounds(70, 400, 70, 30);
//        button.addActionListener( e -> System.out.println("from button"));
//
//        button.setFont(new Font("Arial", Font.BOLD, 14));
//        button.setForeground(Color.WHITE);
//        button.setBackground(new Color(70, 130, 180));
//
//        button.setBorderPainted(false);
//        button.setFocusPainted(false);
//        button.setContentAreaFilled(false);
//        button.setOpaque(true);
//
//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                button.setBackground(new Color(100, 118, 237)); // Hover color
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                button.setBackground(new Color(70, 130, 180)); // Original color
//            }
//        });
//
//        this.add(button);

        window.add(this);
        window.pack();
        window.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smooth scaling
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        //things to be drawn
        main.screen.draw(g2d);

    }
}
