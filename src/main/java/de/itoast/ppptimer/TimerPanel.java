package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel {
    private final PairingTimer pairingTimer;

    public TimerPanel(final int seconds) {
        pairingTimer = new PairingTimer(seconds, this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        drawTheBackground(graphics);
        drawPie(graphics);
        drawTheRemainingTime(graphics);
    }

    private void drawTheBackground(Graphics graphics) {
        Rectangle bounds = this.getBounds();
        graphics.setColor(Color.darkGray);
        graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    private void drawPie(Graphics graphics) {
        determineColorAccordingToRemainingTime(graphics);
        doDrawPie(graphics);
    }

    private void doDrawPie(Graphics graphics) {
        Rectangle bounds = this.getBounds();
        int width = bounds.width;
        int height = bounds.height;
        int usedValue = Math.min(width, height);
        graphics.fillArc(bounds.x, bounds.y, usedValue, usedValue, 90, -(int) pairingTimer.getAngle());
    }

    private void determineColorAccordingToRemainingTime(Graphics graphics) {
        if (pairingTimer.getSecondsLeft() <= 10) {
            if (pairingTimer.getSecondsLeft() % 2 == 0) {
                graphics.setColor(Color.red);
            } else {
                graphics.setColor(Color.gray);
            }
        } else {
            graphics.setColor(Color.gray);
        }
    }

    private void drawTheRemainingTime(Graphics graphics) {
        Rectangle bounds = this.getBounds();
        graphics.setFont(new Font("Verdana", Font.PLAIN, 24));
        graphics.setColor(Color.white);
        graphics.drawString(""+ pairingTimer.getSecondsLeft()+"s", bounds.width/2-10, bounds.height/2-10);
    }
}
