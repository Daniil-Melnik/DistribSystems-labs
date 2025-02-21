package com.etu.labs.GUI.DialogWindows;

import javax.swing.*;
import java.awt.*;

public class AddTemplate extends JFrame {

    protected JButton addButton;

    public AddTemplate(String title, int height) {
        setTitle(title);
        setSize(250, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 250, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel);

        addButton = new JButton("Добавить");
        addButton.setBounds(70, height - 75, 100, 30);
        add(addButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}