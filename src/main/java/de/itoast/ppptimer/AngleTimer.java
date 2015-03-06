package de.itoast.ppptimer;

import java.awt.*;

public interface AngleTimer {
    double getAngle();

    int getSecondsLeft();

    void determineColorAccordingToRemainingTime(Graphics2D graphics2D);

    void cancel();

    boolean isCancelled();

    AngleTimer cloneAndRun();
}
