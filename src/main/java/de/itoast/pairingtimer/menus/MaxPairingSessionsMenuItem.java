package de.itoast.pairingtimer.menus;

import de.itoast.pairingtimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxPairingSessionsMenuItem extends JRadioButtonMenuItem {
    private final int number;
    private TimerConfiguration timerConfiguration;

    public MaxPairingSessionsMenuItem(final TimerConfiguration timerConfiguration) {
        number = 0;
        this.timerConfiguration = timerConfiguration;
        this.addActionListener(createUnlimitedAction(timerConfiguration));
    }

    public MaxPairingSessionsMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        this.number = number;
        this.timerConfiguration = timerConfiguration;
        this.addActionListener(createAction(number, timerConfiguration));
    }

    @Override
    public String getText() {
        if (number > 0) {
            return number + " pairing session" + (number > 1 ? "s" : "");
        }
        return "Unlimited pairing sessions";
    }

    @Override
    public boolean isSelected() {
        if (timerConfiguration == null) {
            return false;
        }
        return timerConfiguration.isSelected(number);
    }

    private ActionListener createUnlimitedAction(final TimerConfiguration timerConfiguration) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setMaxPairingSessions(null);
            }
        };
    }

    private ActionListener createAction(final int number, final TimerConfiguration timerConfiguration) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number == 0) {
                    timerConfiguration.setMaxPairingSessions(number);
                } else {
                    timerConfiguration.setMaxPairingSessions(number);
                }
            }
        };
    }
}
