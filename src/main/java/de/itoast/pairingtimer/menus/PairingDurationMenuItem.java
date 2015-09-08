package de.itoast.pairingtimer.menus;

import de.itoast.pairingtimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PairingDurationMenuItem extends JRadioButtonMenuItem {
    private final int number;
    private final TimerConfiguration timerConfiguration;

    public PairingDurationMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        this.number = number;
        this.timerConfiguration = timerConfiguration;
        addActionListener(createActionListener());
    }

    @Override
    public String getText() {
        return number + " minute" + (number > 1 ? "s" : "");
    }

    @Override
    public boolean isSelected() {
        if (timerConfiguration == null) {
            return false;
        }
        return number == timerConfiguration.getPairingDuration() / 60;
    }

    @Override
    public ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setPairingDuration(number * 60);
            }
        };
    }
}
