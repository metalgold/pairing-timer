package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class PairingTimer extends java.util.Timer {
    private int secondsLeft;
    private double angle;

    public PairingTimer(final int seconds, final JPanel panel) {
        this.secondsLeft = seconds;
        this.schedule(makeTimerTask(seconds, panel), 1000, 1000);
    }

    private TimerTask makeTimerTask(final int seconds, final JPanel panel) {
        return new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;
                angle += 360 / seconds;
                panel.repaint(panel.getBounds());
                if (secondsLeft == 0) {
                    this.cancel();
                }
            }
        };
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public double getAngle() {
        return angle;
    }
}
