package com.etu.labs.GUI.Windows;

import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JButton cpuBtn;
    private JButton pcBtn;

    public MainWindow(){
        setSize(200, 400);
        setLayout(null);

        cpuBtn = new JButton("Процессоры");
        cpuBtn.setBounds(50, 10, 100, 25);
        add(cpuBtn);

        pcBtn = new JButton("Компьютеры");
        pcBtn.setBounds(50, 40, 100, 25);
        add(pcBtn);

        cpuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CpuWindow();
            }
        });

        pcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ComputerWindow();
            }
        });

        setVisible(true);
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}
