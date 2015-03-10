package de.itoast.ppptimer;

public class TimerConfiguration {
    private int pairingDuration;
    private int pauseDuration;
    private int pairingSessionsBeforePause;
    private Integer maxPairingSessions;
    private int pairingSessionCount;

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

    public void setMaxPairingSessions(Integer maxPairingSessions) {
        this.maxPairingSessions = maxPairingSessions;
    }

    public void setPairingSessionsBeforePause(int pairingSessionsBeforePause) {
        this.pairingSessionsBeforePause = pairingSessionsBeforePause;
    }

    public void setPauseDuration(int pauseDuration) {
        this.pauseDuration = pauseDuration;
    }

    public void setPairingDuration(int pairingDuration) {
        this.pairingDuration = pairingDuration;
    }

    public boolean hasLimitedPairingSessions() {
        return maxPairingSessions != null;
    }

    public int getMaxPairingSessions() {
        if (maxPairingSessions==null)
            throw new RuntimeException("Pairings sessions are set unlimited.");
        return maxPairingSessions;
    }

    public boolean hasPairingSessionLimitReached() {
        return pairingSessionCount == getMaxPairingSessions();
    }

    public void incrementPairingSessionCount() {
        pairingSessionCount++;
    }
}
