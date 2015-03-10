package de.itoast.ppptimer.menus;

import de.itoast.ppptimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxPairingSessionsBeforePauseMenuItem extends JRadioButtonMenuItem {
    public MaxPairingSessionsBeforePauseMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        super(number + " pairing session" + (number>1?"s":""), number == timerConfiguration.getPairingSessionsBeforePause());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setPairingSessionsBeforePause(number);
            }
        });
    }
}
