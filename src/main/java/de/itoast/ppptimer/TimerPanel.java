package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel {
    private final PiePainter piePainter = new PiePainter();
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
        piePainter.draw(graphics, timer, this.getBounds(), TimeUtil.remainingTimeToString(timer.getSecondsLeft()));
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
