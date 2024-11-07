
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Display extends JPanel implements Runnable{
    private final String title;
    private final int screenWidth;
    private final int screenHeight;
    private static final int FPS = 60;

    public Thread screenThread = new Thread(this);

    //testing (to be removed)
    Book[] books = new Book[7];
    Book book1 = new Book("Book1", "Fantasy", 10);
    Font arialFont_20;
    //----------------------

    public Display(String title, int width, int height){
        this.title = title;
        this.screenWidth = width;
        this.screenHeight = height;
        arialFont_20 = new Font("Arial", Font.PLAIN, 20);

        books[0] = new Book("Book1", "Fantasy", 7);
        books[1] = new Book("Book2", "Mystery", 4);
        books[2] = new Book("Book3", "Mystery", 8);
        books[3] = new Book("Book4", "Horror", 3);
        books[4] = new Book("Book5", "Computer Science", 5);
        books[5] = new Book("Book6", "Computer Science", 4);
        books[6] = new Book("Book7", "History", 4);

        screenThread.start();
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

        window.add(this);
        window.pack();
        window.setVisible(true);
    }

    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smooth scaling
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        //things to be drawn
        for(int i = 0; i < books.length; i++){
            g2d.drawImage(books[0].getImage(), 30 + (130 * i), 30, null);
        }

        g2d.dispose();

    }

    @Override
    public void run() {
        double drawInterval = (1000000000.0) / FPS, delta = 0;
        long lastTime = System.nanoTime(), currentTime;
        while(screenThread.isAlive()){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                //Update information like player position
                this.update();

                //draw the screen with the updated information
                repaint();

                delta--;
            }
        }
    }
}
