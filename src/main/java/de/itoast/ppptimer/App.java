package de.itoast.ppptimer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        new TimerFrame(new TimerPanel(new TimerConfiguration()));
    }

}
