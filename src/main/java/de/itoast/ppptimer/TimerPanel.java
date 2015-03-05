package de.itoast.ppptimer;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class TimerPanel extends JPanel {
    private double angle;
    private int secondsLeft;

    public TimerPanel(final int seconds) {
        this.angle = 0;
        secondsLeft = seconds;
        final JPanel self = this;
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;
                angle += 360 / seconds;
                self.repaint(self.getBounds());
                if (secondsLeft == 0) {
                    this.cancel();
                }
            }
        }, 1000, 1000);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(Color.darkGray);
        Rectangle bounds = this.getBounds();
        graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);

        if (secondsLeft <= 10) {
            if (secondsLeft % 2 == 0) {
                graphics.setColor(Color.red);
            } else {
                graphics.setColor(Color.gray);
            }
        } else {
            graphics.setColor(Color.gray);
        }
        int width = bounds.width;
        int height = bounds.height;
        int usedValue = Math.min(width, height);
        graphics.fillArc(bounds.x, bounds.y, usedValue, usedValue, 90, -(int) angle);


        graphics.setFont(new Font("Verdana", Font.PLAIN, 24));
        graphics.setColor(Color.white);
        graphics.drawString(""+secondsLeft+"s", bounds.width/2-10, bounds.height/2-10);
    }
}
