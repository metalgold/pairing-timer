package de.itoast.ppptimer;

public class TimerConfiguration {
    private int pairingDuration;
    private int pauseDuration;
    private int pairingSessionsBeforePause;

    public TimerConfiguration(String[] args) {
        pairingDuration = Integer.parseInt(args[0]);
        pauseDuration = Integer.parseInt(args[1]);
        pairingSessionsBeforePause = Integer.parseInt(args[2]);
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
}
