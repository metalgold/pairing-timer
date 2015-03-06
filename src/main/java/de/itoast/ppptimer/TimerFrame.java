package de.itoast.ppptimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerFrame extends JFrame {
    private final TimerPanel timerPanel;

    public TimerFrame(final TimerPanel timerPanel) throws HeadlessException {
        JFrame frame = new JFrame("3P Timer - Pairing, Productivity, Pauses");
        frame.setMinimumSize(new Dimension(200, 200));
        frame.getSize().setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        this.timerPanel = timerPanel;
        this.timerPanel.setSize(400, 400);
        frame.add(this.timerPanel, BorderLayout.CENTER);

        addMenuBarTo(frame);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
    }

    private void addMenuBarTo(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        addSettingsMenuTo(menuBar);
        frame.setJMenuBar(menuBar);
    }

    private void addSettingsMenuTo(JMenuBar menuBar) {
        JMenu settings = new JMenu("Settings");

        final JMenuItem menuItem;
        menuItem = new JMenuItem("Start timer");
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerPanel.toggle();
                menuItem.setText(timerPanel.getToggleText());
            }
        };

        menuItem.addActionListener(action);
        menuItem.setEnabled(true);
        settings.add(menuItem);


        addPairingDurationSection(settings);
        addPauseDurationSection(settings);
        addPauseSection(settings);
        menuBar.add(settings);
    }

    private void addPauseSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pause after..."));
        addMenuItem(settings, "1 pairing session");
        addMenuItem(settings, "2 pairing sessions");
        addMenuItem(settings, "3 pairing sessions");
        addMenuItem(settings, "4 pairing sessions");
        addMenuItem(settings, "5 pairing sessions");
        addMenuItem(settings, "6 pairing sessions");
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

    private void addMenuItem(JMenu settings, String text, ActionListener action) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(text);
        menuItem.addActionListener(action);
        menuItem.setEnabled(true);
        settings.add(menuItem);
    }

    private void addMenuItem(JMenu settings, String text) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(text);
        menuItem.setEnabled(false);
        settings.add(menuItem);
    }

}
