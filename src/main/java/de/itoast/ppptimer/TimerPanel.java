package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class TimerPanel extends JPanel {
    private AngleTimer timer;
    private TimerConfiguration timerConfiguration;

    public TimerPanel(final TimerConfiguration timerConfiguration) {
        this.timerConfiguration = timerConfiguration;
        timer = new PairingTimer(timerConfiguration, this);
        this.setLayout(new BorderLayout());
        this.setDoubleBuffered(true);
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

        int x,y,width,height;

        if (/* wide or same */ bounds.width > bounds.height) {
            height = width = bounds.height - 10;
            x = (int)((bounds.width - width) / 2.0) + 5;
            y = 5;
        } else /* tall */ {
            width = height = bounds.width-10;
            x = 5;
            y = (int) ((bounds.height - height) / 2.0) +5 ;
        }

        BasicStroke s = new BasicStroke(5, 0, 0);
        g2.setStroke(s);
        g2.draw(new Ellipse2D.Double(x, y, width, height));
        g2.fill(new Arc2D.Double(x, y, width, height, 90, -timer.getAngle(), Arc2D.PIE));
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

    public void toggle() {
        if (this.timer.isCancelled()) {
            this.timer = timer.resume();
        } else {
            this.timer.cancel();
        }
    }

    public String getToggleText() {
        return this.timer.isCancelled() ? "Start timer" : "Stop timer";
    }

    public void restart() {
        if (this.timer.isCancelled()) {
            this.timer = new PairingTimer(timerConfiguration, this);
        } else {
            this.timer.cancel();
            this.timer = new PairingTimer(timerConfiguration, this);
            this.timer.start();
        }
    }
}
