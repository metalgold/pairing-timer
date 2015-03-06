package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class TimerPanel extends JPanel {
    private final PairingTimer pairingTimer;

    public TimerPanel(final int seconds) {
        pairingTimer = new PairingTimer(seconds, this);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = initGraphics(graphics);
        drawTheBackground(g2);
        drawPie(g2);
        drawTheRemainingTime(g2);
        g2.dispose();
    }

    private Graphics2D initGraphics(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        return g2;
    }

    private void drawTheBackground(Graphics2D g2) {
        Rectangle bounds = this.getBounds();
        g2.setColor(Color.darkGray);
        g2.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    private void drawPie(Graphics2D g2) {
        determineColorAccordingToRemainingTime(g2);
        doDrawPie(g2);
    }

    private void doDrawPie(Graphics2D g2) {
        Rectangle bounds = this.getBounds();
        int usedValue = Math.min(bounds.width, bounds.height);
        g2.fill(new Arc2D.Double(bounds.x, bounds.y, usedValue, usedValue, 90, -pairingTimer.getAngle(), Arc2D.PIE));
    }

    private void determineColorAccordingToRemainingTime(Graphics2D g2) {
        if (pairingTimer.getSecondsLeft() <= 10) {
            if (pairingTimer.getSecondsLeft() % 2 == 0) {
                g2.setColor(Color.red);
            } else {
                g2.setColor(Color.gray);
            }
        } else {
            g2.setColor(Color.gray);
        }
    }

    private void drawTheRemainingTime(Graphics2D g2) {
        Rectangle bounds = this.getBounds();
        g2.setFont(new Font("Verdana", Font.PLAIN, 24));
        g2.setColor(Color.white);
        g2.drawString("" + pairingTimer.getSecondsLeft() + "s", bounds.width / 2 - 10, bounds.height / 2 - 10);
    }
}
