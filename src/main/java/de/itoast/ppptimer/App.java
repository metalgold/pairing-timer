package de.itoast.ppptimer;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        TimerConfiguration timerConfiguration;
        if (args != null && args.length > 0 && args.length<=4) {
            timerConfiguration = new TimerConfiguration(args);
        } else {
            timerConfiguration = new TimerConfiguration();
        }
        TimerPanel timerPanel = new TimerPanel(timerConfiguration);
        new TimerFrame(timerPanel, timerConfiguration);
    }
}
