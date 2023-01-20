package Bubble2;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class BubblePanel extends JPanel {
    Random rand = new Random();
    ArrayList<Bubble> bubbleList;
    int size = 25;
    Timer timer;
    int delay = 20;

   // private int x, y;
    private final int MAX_SPEED =10;


    public BubblePanel() {
        timer = new Timer(delay, (ActionListener) new BubbleListener());
        bubbleList = new ArrayList<Bubble>();
        setBackground(Color.BLACK);

        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
        addMouseWheelListener(new BubbleListener());
    //    testBubbles();
        timer.start();

    }


    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);
        for (Bubble bubble : bubbleList) {
            bubble.draw(canvas);
        }
    }

 /*       public void testBubbles(){
        for (int i = 0; i < 100;i++){
             x = rand.nextInt(600);
            y = rand.nextInt(400);
            int size = rand.nextInt(50);
            bubbleList.add(new Bubble(x,y,size));
        }
        repaint();
}
*/
    private class BubbleListener extends MouseAdapter implements ActionListener {
        public void mousePressed(MouseEvent event) {
            bubbleList.add(new Bubble(event.getX(), event.getY(), size));
            repaint();
        }

        public void mouseDragged(MouseEvent event) {
            bubbleList.add(new Bubble(event.getX(), event.getY(), size));
            repaint();
        }

        public void mouseWheelMoved(MouseWheelEvent e) {

            size += e.getUnitsToScroll();

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Bubble bubble : bubbleList) {
                bubble.update();
                repaint();

            }

        }
    }

    private class Bubble {
        private int dspeed = 0;
        private int xspeed, yspeed;
        private int x, y;
        private int size;
        private Color color;

        public Bubble(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            xspeed = rand.nextInt(MAX_SPEED*2+1)-MAX_SPEED;
            yspeed = rand.nextInt(MAX_SPEED*2+1)-MAX_SPEED;
            if (xspeed ==0 || yspeed ==0){
                xspeed = rand.nextInt(MAX_SPEED*2+1)-MAX_SPEED;
                yspeed = rand.nextInt(MAX_SPEED*2+1)-MAX_SPEED;
            }

                    color = new Color(rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255));
            dspeed = 0;


        }


        public void draw(Graphics g) {
            g.setColor(color);
            g.drawRect(x - size / 2, y - size / 2, size, size);

        }

        public void update() {
           x += xspeed;
            y += yspeed;
            if(x-size/2<=1 || x+size/2>getWidth()){
                xspeed =-xspeed;

            }
            if(y-size/2<=1 || y+size/2>getHeight()){

                yspeed =-yspeed;

            }
        }
    }


}
