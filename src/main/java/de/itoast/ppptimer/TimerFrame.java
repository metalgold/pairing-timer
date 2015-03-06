package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;

public class TimerFrame extends JFrame {
    public TimerFrame(TimerPanel timerPanel) throws HeadlessException {
        JFrame frame = new JFrame("3P Timer - Pairing, Productivity, Pauses");
        frame.setMinimumSize(new Dimension(400, 400));
        frame.getSize().setSize(400, 400);
        frame.setMaximumSize(new Dimension(400, 400));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(timerPanel);

        JMenuBar menuBar = new JMenuBar();
        addSettingsMenuTo(menuBar);
        frame.setJMenuBar(menuBar);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
    }

    private void addSettingsMenuTo(JMenuBar menuBar) {
        JMenu settings = new JMenu("Settings");
        addMenuItem(settings, "Start timer");
        addPairingDurationSection(settings);
        addPauseDurationSection(settings);
        addPauseSection(settings);
        menuBar.add(settings);
    }

    private void addPauseSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pause after..."));
        addMenuItem(settings, "1 pairing session");
        addMenuItem(settings, "2 pairing session");
        addMenuItem(settings, "3 pairing session");
        addMenuItem(settings, "4 pairing session");
        addMenuItem(settings, "5 pairing session");
        addMenuItem(settings, "6 pairing session");
    }

    private void addPauseDurationSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pause duration"));
        addMenuItem(settings, "5 minutes");
        addMenuItem(settings, "10 minutes");
        addMenuItem(settings, "15 minutes");
        addMenuItem(settings, "20 minutes");
        addMenuItem(settings, "25 minutes");
    }

    private void addPairingDurationSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pairing duration"));
        String text = "5 minutes";
        addMenuItem(settings, text);
        addMenuItem(settings, "10 minutes");
        addMenuItem(settings, "15 minutes");
        addMenuItem(settings, "20 minutes");
        addMenuItem(settings, "25 minutes");
    }

    private void addMenuItem(JMenu settings, String text) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(text);
        menuItem.setEnabled(false);
        settings.add(menuItem);
    }

}
