package de.itoast.ppptimer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        new TimerFrame(new TimerPanel(Integer.parseInt(args[0])));
    }

}
