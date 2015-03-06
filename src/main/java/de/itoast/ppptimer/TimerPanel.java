package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class TimerPanel extends JPanel {
    private AngleTimer timer;

    public TimerPanel(final TimerConfiguration timerConfiguration) {
        timer = new PairingTimer(timerConfiguration, this);
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
        timer.determineColorAccordingToRemainingTime(g2);
        doDrawPie(g2);
    }

    private void doDrawPie(Graphics2D g2) {
        Rectangle bounds = this.getBounds();
        int minValue = Math.min(bounds.width, bounds.height);
        int maxValue = Math.max(bounds.width, bounds.height);
        int distance = (maxValue - minValue) / 2;
        int usedValue = Math.min(bounds.width, bounds.height) - distance * 2;
        System.out.println(bounds);


        int xOrigin = (bounds.width - usedValue) / 2;
        g2.fill(new Arc2D.Double(xOrigin, distance, usedValue, usedValue, 90, -timer.getAngle(), Arc2D.PIE));
    }

    private void drawTheRemainingTime(Graphics2D g2) {
        g2.setFont(new Font("Verdana", Font.PLAIN, 24));
        g2.setColor(Color.white);
        g2.drawString(getRemainingTime(), 0, 24);
    }

    private String getRemainingTime() {
        int millisLeft = timer.getSecondsLeft() * 1000;
        int h = (millisLeft / 1000) / 3600;
        int m = ((millisLeft / 1000) / 60) % 60;
        int s = (millisLeft / 1000) % 60;

        StringBuilder sb = new StringBuilder();

        if (h > 0) {
            sb.append(h + "h");
        }

        if (m > 0) {
            sb.append(m + "m");
        }

        if (s > 0) {
            sb.append(s + "s");
        }

        return sb.toString();
    }

    public void setTimer(AngleTimer timer) {
        this.timer = timer;
    }
}
