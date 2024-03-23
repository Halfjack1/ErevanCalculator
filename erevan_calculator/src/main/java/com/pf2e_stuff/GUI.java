package com.pf2e_stuff;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class GUI implements EventListener{
    private JFrame frame;
    private JPanel panel;

    public JLabel damageIndicator;
    public damageCalculator dmgCalc;

    //constructor that creates the window
    public GUI(){
        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Erevan Calculator");
        frame.pack();
        frame.setVisible(true);
    }
    //adds a label
    public JLabel addLabel(String text){
        JLabel label = new JLabel(text);
        panel.add(label);
        frame.pack();
        return label;
    }
    //adds a checkbox with text
    public JCheckBox addCheckBox(String text, Boolean defaultState){
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setSelected(defaultState);
        panel.add(checkBox);
        checkBox.addActionListener(new ActionListener() {
            @Override
            //recalculates the damage when the checkbox is modified
            public void actionPerformed(ActionEvent event) {
                dmgCalc.totalDamage();
            }
        });
        frame.pack();
        return checkBox;
    }
    //adds a dropdown
    public JComboBox<String> addDropdown(String[] elements){
        JComboBox<String> dropdown = new JComboBox<String>();
        panel.add(dropdown);
        for(String element : elements){
            dropdown.addItem(element);
        }
        dropdown.addActionListener(new ActionListener() {
            @Override
            //recalculates the damage when the dropdown is modified
            public void actionPerformed(ActionEvent event) {
                dmgCalc.totalDamage();
            }
        });
        
        frame.pack();
        return dropdown;
    }
    //gives the GUI object a damage calculator object
    public void setDmgCalc(damageCalculator newDmgCalc){
        dmgCalc = newDmgCalc;
    }
}