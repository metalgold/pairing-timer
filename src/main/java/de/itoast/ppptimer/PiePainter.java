package de.itoast.ppptimer;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class PiePainter implements Serializable {
    public PiePainter() {
    }

    void draw(Graphics graphics, AngleTimer angleTimer, Rectangle bounds, String remainingTime) {
        Graphics2D g2 = initGraphics(graphics);
        drawTheBackground(g2, bounds);
        drawPie(g2, angleTimer, bounds);
        drawTheRemainingTime(g2, remainingTime);
        g2.dispose();
    }

    Graphics2D initGraphics(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        return g2;
    }

    void drawTheBackground(Graphics2D g2, Rectangle bounds) {
        g2.setColor(Color.darkGray);
        g2.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    void drawPie(Graphics2D g2, AngleTimer angleTimer, Rectangle bounds) {
        angleTimer.determineColorAccordingToRemainingTime(g2);
        doDrawPie(g2, angleTimer, bounds);
    }

    void doDrawPie(Graphics2D g2, AngleTimer angleTimer, Rectangle bounds1) {

        int x, y, width, height;

        if (/* wide or same */ bounds1.width > bounds1.height) {
            height = width = bounds1.height - 10;
            x = (int) ((bounds1.width - width) / 2.0) + 5;
            y = 5;
        } else /* tall */ {
            width = height = bounds1.width - 10;
            x = 5;
            y = (int) ((bounds1.height - height) / 2.0) + 5;
        }

        BasicStroke s = new BasicStroke(5, 0, 0);
        g2.setStroke(s);
        g2.draw(new Ellipse2D.Double(x, y, width, height));
        g2.fill(new Arc2D.Double(x, y, width, height, 90, -angleTimer.getAngle(), Arc2D.PIE));
    }

    void drawTheRemainingTime(Graphics2D g2, String remainingTime) {
        g2.setFont(new Font("Verdana", Font.PLAIN, 24));
        g2.setColor(Color.white);
        g2.drawString(remainingTime, 0, 24);
    }
}