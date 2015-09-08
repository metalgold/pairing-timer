package de.itoast.pairingtimer.menus;

import de.itoast.pairingtimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseDurationMenuItem extends JRadioButtonMenuItem {
    private final int number;
    private final TimerConfiguration timerConfiguration;

    public PauseDurationMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        this.number = number;
        this.timerConfiguration = timerConfiguration;
        addActionListener(createAction());
    }

    @Override
    public boolean isSelected() {
        if (timerConfiguration == null)
            return false;
        return number == timerConfiguration.getPauseDuration() / 60;
    }

    @Override
    public String getText() {
        return number + " minute" + (number > 1 ? "s" : "");
    }

    private ActionListener createAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setPauseDuration(number * 60);
            }
        };
    }
}
