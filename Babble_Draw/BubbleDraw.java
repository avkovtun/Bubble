package Babble_Draw;

import Babble_Draw.BubblePanel;

import javax.swing.JFrame;
public class BubbleDraw extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Рисовалка");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        frame.getContentPane().add(new BabblePanel())
        frame.getContentPane().add(new BubblePanel());
        frame.setSize(new java.awt.Dimension(600,400));

        frame.setVisible(true);

    }
}
