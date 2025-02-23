package com.etu.labs.GUI.Windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WindowTemplate extends JFrame {

    protected JTable table;
    protected DefaultTableModel model;
    private JScrollPane scrollPane;
    private JLabel labelTitle;
    private JLabel labelSelect;

    public  WindowTemplate (String title, String selectTitle, int width, int height){
        setTitle(title);
        setSize(width, height);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelTitle = new JLabel(title);
        labelTitle.setBounds(0, 10, width, 25);
        add(labelTitle);

        model = new DefaultTableModel();
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultEditor(Object.class, null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 35, width - 30, height - 100);
        add(scrollPane, BorderLayout.CENTER);

        labelSelect = new JLabel(selectTitle);
        labelSelect.setBounds(10, height - 70, 150, 25);
        add(labelSelect);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
