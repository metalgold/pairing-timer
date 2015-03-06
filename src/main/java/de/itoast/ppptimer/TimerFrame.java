package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;

public class TimerFrame extends JFrame {
    public TimerFrame(TimerPanel timerPanel) throws HeadlessException {
        JFrame frame = new JFrame("3P Timer - Pairing, Productivity, Pauses");
        frame.setMinimumSize(new Dimension(400, 400));
        frame.getSize().setSize(400, 400);
        frame.setMaximumSize(new Dimension(400, 400));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(timerPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
    }

}
