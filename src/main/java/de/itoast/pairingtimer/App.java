package de.itoast.pairingtimer;

public class App {

    public static void main(String[] args) throws InterruptedException {
        loadUIWith(TimerConfiguration.configure(args));
    }

    private static void loadUIWith(TimerConfiguration timerConfiguration) {
        TimerPanel timerPanel = new TimerPanel(timerConfiguration);
        new TimerFrame(timerPanel, timerConfiguration);
    }

}
