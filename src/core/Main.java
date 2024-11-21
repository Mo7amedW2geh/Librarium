package core;

import UI.Display;
import UI.Screen;
import input.MouseManager;

public class Main implements Runnable {
    private final Display display;

    //System
    private Thread screenThread;
    private final MouseManager mouseManager = new MouseManager();
    public Screen screen = new Screen(mouseManager);

    //Main panel
    public Main() {
        display = new Display("test", 940, 540, this);
        display.addMouseListener(mouseManager);
        display.addMouseMotionListener(mouseManager);
    }

    public void start(){
        Data.loadBooksFromFile();

        screenThread = new Thread(this);
        screenThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (1000000000.0) / Screen.FPS, delta = 0;
        long lastTime = System.nanoTime(), currentTime;
        while(screenThread.isAlive()){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                //Update information like player position
                this.update();

                //draw the screen with the updated information
                display.repaint();

                delta--;
            }
        }
    }


    public void update(){
        screen.update();
    }
}
