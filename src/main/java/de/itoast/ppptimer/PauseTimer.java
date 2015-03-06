package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PauseTimer extends Timer implements AngleTimer {
    private final TimerConfiguration timerConfiguration;
    private TimerPanel panel;
    private int secondsLeft;
    private int duration;
    private double angle;
    private boolean cancelled;

    public PauseTimer(final TimerConfiguration timerConfiguration, final TimerPanel panel) {
        this.timerConfiguration = timerConfiguration;
        this.panel = panel;
        this.secondsLeft = this.timerConfiguration.getPauseDuration();
        this.duration = this.timerConfiguration.getPauseDuration();

        this.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;
                angle += 360.0 / duration;
                panel.repaint(panel.getBounds());
                if (secondsLeft==0) {
                    Toolkit.getDefaultToolkit().beep();
                    PairingTimer timer = new PairingTimer(timerConfiguration, panel);
                    panel.setTimer(timer);
                    this.cancel();
                }
            }
        }, 1000, 1000);
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void determineColorAccordingToRemainingTime(Graphics2D g2) {
        if (getSecondsLeft() <= 10) {
            if (getSecondsLeft() % 2 == 0) {
                g2.setColor(Color.red);
            } else {
                g2.setColor(Color.green);
            }
        } else {
            g2.setColor(Color.green);
        }
    }

    @Override
    public void cancel() {
        super.cancel();
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public AngleTimer cloneAndRun() {
            PauseTimer pauseTimer = new PauseTimer(timerConfiguration, panel);
            pauseTimer.secondsLeft = this.secondsLeft;
            pauseTimer.angle = this.angle;
            pauseTimer.cancelled = false;
            return pauseTimer;

    }
}
