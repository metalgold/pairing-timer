package de.itoast.ppptimer.menus;

import de.itoast.ppptimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PairingDurationMenuItem extends JRadioButtonMenuItem {
    public PairingDurationMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        super(number + " minute" + (number > 1 ? "s" : ""), number == timerConfiguration.getPairingDuration()/60);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setPairingDuration(number*60);
            }
        });
    }
}
