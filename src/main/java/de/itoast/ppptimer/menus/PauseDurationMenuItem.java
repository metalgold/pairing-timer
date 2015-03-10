package de.itoast.ppptimer.menus;

import de.itoast.ppptimer.TimerConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseDurationMenuItem extends JRadioButtonMenuItem {
    public PauseDurationMenuItem(final int number, final TimerConfiguration timerConfiguration) {
        super(number + " minute" + (number > 1 ? "s" : ""), number == timerConfiguration.getPauseDuration()/60);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerConfiguration.setPauseDuration(number*60);
            }
        });
    }
}
