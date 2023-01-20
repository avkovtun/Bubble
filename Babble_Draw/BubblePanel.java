package Babble_Draw;
import javax.swing.JPanel;
import java.awt.event.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BubblePanel extends JPanel {
    Random rand = new Random();
    ArrayList<Bubble> bubbleList ;
    int size =25;
    public BubblePanel(){
       bubbleList = new ArrayList<Bubble>();
       setBackground(Color.BLACK);
      // testBubbles();
        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
        addMouseWheelListener(new BubbleListener());

    }


public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);
    for (Bubble bubble : bubbleList) {
        bubble.draw(canvas);
    }
}

/*//public void testBubbles(){
        for (int i = 0; i < 1000;i++){
            int x = rand.nextInt(600);
            int y = rand.nextInt(400);
            int size = rand.nextInt(50);
            bubbleList.add(new Bubble(x,y,size));
        }
        repaint();
}*/

private class BubbleListener extends MouseAdapter {
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
}
    private class Bubble{
        private int x, y;
        private int size;
        private Color color;
        public Bubble(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
            color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        }
        public void draw(Graphics g){
            g.setColor(color);
            g.fillOval(x-size/2, y-size/2, size,size);

    }
}
}
