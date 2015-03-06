package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class PairingTimer extends java.util.Timer implements AngleTimer {
    private int secondsLeft;
    private double angle;
    private int count;
    private TimerConfiguration timerConfiguration;
    private TimerPanel panel;

    public PairingTimer(TimerConfiguration timerConfiguration, TimerPanel panel) {
        this(timerConfiguration.getPairingDuration(), panel);
        this.timerConfiguration = timerConfiguration;
        this.panel = panel;
    }

    private PairingTimer(final int seconds, final TimerPanel panel) {
        this.secondsLeft = seconds;
        this.schedule(makeTimerTask(seconds, panel), 1000, 1000);
    }

    private TimerTask makeTimerTask(final int seconds, final JPanel panel) {
        return new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;
                angle += 360.0 / seconds;
                panel.repaint(panel.getBounds());
                if (secondsLeft == 0) {
                    startOver(seconds);
                }
            }
        };
    }

    private void startOver(int seconds) {
        count++;
        secondsLeft = seconds;
        angle = 0;
        Toolkit.getDefaultToolkit().beep();
        if (count==timerConfiguration.getPairingSessionsBeforePause()) {
            PauseTimer pauseTimer = new PauseTimer(timerConfiguration, panel);
            panel.setTimer(pauseTimer);
            this.cancel();
        }
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public double getAngle() {
        return angle;
    }

    public void determineColorAccordingToRemainingTime(Graphics2D g2) {
        if (getSecondsLeft() <= 10) {
            if (getSecondsLeft() % 2 == 0) {
                g2.setColor(Color.red);
            } else {
                g2.setColor(Color.gray);
            }
        } else {
            g2.setColor(Color.gray);
        }
    }
}
