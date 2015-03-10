package de.itoast.ppptimer;

/**
 * Hello world!
 */
public class App {
    private static TimerConfiguration timerConfiguration = new TimerConfiguration();

    public static void main(String[] args) throws InterruptedException {
        if (args != null && args.length > 0 && args.length<=4) {
            timerConfiguration = new TimerConfiguration(args);
        } else {
            timerConfiguration = new TimerConfiguration();
        }
        new TimerFrame(new TimerPanel(timerConfiguration));
    }

}
