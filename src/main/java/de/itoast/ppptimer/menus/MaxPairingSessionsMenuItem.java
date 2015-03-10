package de.itoast.ppptimer.menus;

import de.itoast.ppptimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxPairingSessionsMenuItem extends JRadioButtonMenuItem {
    public MaxPairingSessionsMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        super(number + " pairing session" + (number>1?"s":""), number == timerConfiguration.getMaxPairingSessions());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setMaxPairingSessions(number);
            }
        });
    }
}
