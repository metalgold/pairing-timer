package de.itoast.ppptimer;

import de.itoast.ppptimer.menus.MaxPairingSessionsBeforePauseMenuItem;
import de.itoast.ppptimer.menus.MaxPairingSessionsMenuItem;
import de.itoast.ppptimer.menus.PairingDurationMenuItem;
import de.itoast.ppptimer.menus.PauseDurationMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerFrame extends JFrame {
    private final TimerPanel timerPanel;
    private TimerConfiguration timerConfiguration;

    public TimerFrame(final TimerPanel timerPanel, TimerConfiguration timerConfiguration) throws HeadlessException {
        this.timerConfiguration = timerConfiguration;
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
        addMaxPairingSessionsSection(settings);
        menuBar.add(settings);
    }

    private void addMaxPairingSessionsSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Max Pairing sessions..."));

        ButtonGroup group = new ButtonGroup();

        MaxPairingSessionsMenuItem item = new MaxPairingSessionsMenuItem(timerConfiguration);
        group.add(item);
        settings.add(item);

        for (int i=1;i<=6;i++) {
            item = new MaxPairingSessionsMenuItem(i, timerConfiguration);
            group.add(item);
            settings.add(item);
        }

    }

    private void addPauseSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pause after..."));

        ButtonGroup group = new ButtonGroup();

        for (int i=1;i<=6;i++) {
            MaxPairingSessionsBeforePauseMenuItem item = new MaxPairingSessionsBeforePauseMenuItem(i, timerConfiguration);
            group.add(item);
            settings.add(item);
        }

    }

    private void addPauseDurationSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pause duration"));

        ButtonGroup group = new ButtonGroup();

        for (int i = 1; i <= 5; i++) {
            PauseDurationMenuItem item = new PauseDurationMenuItem(i * 5, timerConfiguration);
            settings.add(item);
            group.add(item);
        }
    }

    private void addPairingDurationSection(JMenu settings) {
        settings.add(new JSeparator());
        settings.add(new JLabel("Pairing duration"));

        int[] minutes = {10, 15, 20, 25};


        ButtonGroup group = new ButtonGroup();

        for (int minute : minutes) {
            PairingDurationMenuItem menuItem = new PairingDurationMenuItem(minute, timerConfiguration);
            settings.add(menuItem);
            group.add(menuItem);
        }
    }

}
