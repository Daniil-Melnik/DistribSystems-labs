package com.etu.labs.GUI.DialogWindows;

import javax.swing.*;
import java.awt.*;

public class AddTemplate extends JFrame {

    protected JButton addButton;

    public AddTemplate() {
        setTitle("Добавление элемента");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Добавление элемента", SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 500, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel);

        addButton = new JButton("Добавить");
        addButton.setBounds(200, 230, 100, 30);
        add(addButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}