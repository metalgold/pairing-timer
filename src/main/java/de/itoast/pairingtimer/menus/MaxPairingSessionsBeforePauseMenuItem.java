package de.itoast.pairingtimer.menus;

import de.itoast.pairingtimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxPairingSessionsBeforePauseMenuItem extends JRadioButtonMenuItem {
    private int number;
    private TimerConfiguration timerConfiguration;

    public MaxPairingSessionsBeforePauseMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        this.number = number;
        this.timerConfiguration = timerConfiguration;
        addActionListener(createActionListener());
    }

    public ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setPairingSessionsBeforePause(number);
            }
        };
    }

    @Override
    public String getText() {
        return number + " pairing session" + (number > 1 ? "s" : "");
    }

    @Override
    public boolean isSelected() {
        if (timerConfiguration == null)
            return false;
        return timerConfiguration.isMaximumPairingSessionsBeforePauseReached(number);
    }
}

