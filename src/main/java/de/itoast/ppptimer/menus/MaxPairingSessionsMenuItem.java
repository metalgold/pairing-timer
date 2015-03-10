package de.itoast.ppptimer.menus;

import de.itoast.ppptimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxPairingSessionsMenuItem extends JRadioButtonMenuItem {
    public MaxPairingSessionsMenuItem(final TimerConfiguration timerConfiguration) {
        super("Unlimited pairing sessions", isSelected(0, timerConfiguration));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setMaxPairingSessions(null);
            }
        });
    }

    public MaxPairingSessionsMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        super(number + " pairing session" + (number > 1 ? "s" : ""), isSelected(number, timerConfiguration));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number == 0) {
                    timerConfiguration.setMaxPairingSessions(number);
                } else {
                    timerConfiguration.setMaxPairingSessions(number);
                }
            }
        });
    }

    private static boolean isSelected(int number, TimerConfiguration timerConfiguration) {
        if (number > 0) {
            if (timerConfiguration.hasLimitedPairingSessions()) {
                return timerConfiguration.getMaxPairingSessions() == number;
            } else {
                return false;
            }
        } else {
            return !timerConfiguration.hasLimitedPairingSessions();
        }
    }
}
