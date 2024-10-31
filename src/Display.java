
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Display extends JPanel implements Runnable{
    private final String title;
    private final int screenWidth;
    private final int screenHeight;
    private static final int FPS = 60;

    public Thread screenThread = new Thread(this);

    public Display(String title, int width, int height){
        this.title = title;
        this.screenWidth = width;
        this.screenHeight = height;

        createDisplay();
    }

    public void createDisplay(){
        JFrame window = new JFrame(title);
        window.setSize(screenWidth, screenHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        window.add(this);
        window.pack();
        window.setVisible(true);
    }

    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //things to be drawn

        g2d.dispose();

    }

    @Override
    public void run() {
        double drawInterval = (1000000000.0) / FPS, delta = 0;
        long lastTime = System.nanoTime(), timer = 0, currentTime;
        int frames = 0;

        while(screenThread.isAlive()){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                //Update information like player position
                this.update();

                //draw the screen with the updated information
                repaint();

                delta--;
                frames++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + frames);
                frames = 0;
                timer = 0;
            }
        }
    }
}
