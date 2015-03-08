package de.itoast.ppptimer;

public class TimerConfiguration {
    private int pairingDuration;
    private int pauseDuration;
    private int pairingSessionsBeforePause;
    private Integer maxPairingSessions;

    public TimerConfiguration() {
        pairingDuration = 600;
        pauseDuration = 300;
        pairingSessionsBeforePause = 4;
    }

    public TimerConfiguration(String[] args) {
        pairingDuration = Integer.parseInt(args[0]);
        pauseDuration = Integer.parseInt(args[1]);
        pairingSessionsBeforePause = Integer.parseInt(args[2]);
        maxPairingSessions = Integer.parseInt(args[3]);
    }

    public int getPairingDuration() {
        return pairingDuration;
    }

    public int getPauseDuration() {
        return pauseDuration;
    }

    public int getPairingSessionsBeforePause() {
        return pairingSessionsBeforePause;
    }

    public boolean hasLimitedPairingSessions() {
        return maxPairingSessions != null;
    }

    public int getMaxPairingSessions() {
        if (maxPairingSessions==null)
            throw new RuntimeException("Pairings sessions are set unlimited.");
        return maxPairingSessions;
    }
}
