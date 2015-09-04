package de.itoast.pairingtimer;

import java.io.Serializable;

public class TimeUtil implements Serializable {
    static String remainingTimeToString(int secondsLeft) {
        int millisLeft = secondsLeft * 1000;
        int h = (millisLeft / 1000) / 3600;
        int m = ((millisLeft / 1000) / 60) % 60;
        int s = (millisLeft / 1000) % 60;

        StringBuilder sb = new StringBuilder();

        if (h > 0) {
            sb.append(h).append("h");
        }

        if (m > 0) {
            sb.append(m).append("m");
        }

        if (s > 0) {
            sb.append(s).append("s");
        }

        return sb.toString();
    }
}