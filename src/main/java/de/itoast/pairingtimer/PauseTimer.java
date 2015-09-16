package de.itoast.pairingtimer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PauseTimer implements AngleTimer {
    private final TimerConfiguration timerConfiguration;
    private TimerPanel panel;
    private int secondsLeft;
    private int duration;
    private double angle;
    private boolean cancelled;
    private Timer timer;

    public PauseTimer(final TimerConfiguration timerConfiguration, final TimerPanel panel) {
        this.timerConfiguration = timerConfiguration;
        this.panel = panel;
        this.secondsLeft = this.timerConfiguration.getPauseDuration();
        this.duration = this.timerConfiguration.getPauseDuration();
        this.cancelled = true;
        this.timer = new Timer();
    }

    private TimerTask makeTimerTask(final TimerPanel panel) {
        return new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;
                angle += 360.0 / duration;
                panel.repaint(panel.getBounds());
                if (secondsLeft == 0) {
                    startPairing();
                }
            }
        };
    }

    private void startPairing() {
        angle = 360;
        panel.repaint(panel.getBounds());
        Toolkit.getDefaultToolkit().beep();
        PairingTimer timer = new PairingTimer(timerConfiguration, panel);
        panel.setTimer(timer);
        timer.start();
        this.cancel();
    }

    public void start() {
        timer.schedule(makeTimerTask(panel), 1000, 1000);
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
        timer.cancel();
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public AngleTimer resume() {
        PauseTimer pauseTimer = new PauseTimer(timerConfiguration, panel);
        pauseTimer.secondsLeft = this.secondsLeft;
        pauseTimer.angle = this.angle;
        pauseTimer.cancelled = false;
        pauseTimer.start();
        return pauseTimer;

    }
}
