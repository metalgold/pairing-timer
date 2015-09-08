package de.itoast.pairingtimer;

public class TimerConfiguration {
    private int pairingDuration;
    private int pauseDuration;
    private int pairingSessionsBeforePause;
    private Integer maxPairingSessions;
    private int pairingSessionCount;
    private ConfiguationChangeListener configuationChangeListener;

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

    static TimerConfiguration configure(String[] args) {
        TimerConfiguration timerConfiguration;
        if (args != null && args.length > 0 && args.length<=4) {
            timerConfiguration = new TimerConfiguration(args);
        } else {
            timerConfiguration = new TimerConfiguration();
        }
        return timerConfiguration;
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
        configuationChangeListener.notifyAboutConfigurationChange();
    }

    public void setPairingSessionsBeforePause(int pairingSessionsBeforePause) {
        this.pairingSessionsBeforePause = pairingSessionsBeforePause;
        configuationChangeListener.notifyAboutConfigurationChange();

    }

    public void setPauseDuration(int pauseDuration) {
        this.pauseDuration = pauseDuration;
        configuationChangeListener.notifyAboutConfigurationChange();
    }

    public void setPairingDuration(int pairingDuration) {
        this.pairingDuration = pairingDuration;
        configuationChangeListener.notifyAboutConfigurationChange();
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

    public void setConfiguationChangeListener(ConfiguationChangeListener configuationChangeListener) {
        this.configuationChangeListener = configuationChangeListener;
    }

    public boolean isMaximumPairingSessionsBeforePauseReached(int number) {
        return number == this.getPairingSessionsBeforePause();
    }

    public boolean isSelected(int number) {
        if (number > 0) {
            return this.hasLimitedPairingSessions()
                    && this.getMaxPairingSessions() == number;
        } else {
            return !this.hasLimitedPairingSessions();
        }
    }
}
