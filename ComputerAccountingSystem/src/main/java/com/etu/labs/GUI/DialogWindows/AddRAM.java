package com.etu.labs.GUI.DialogWindows;

import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.RandomAccessMemory;
import com.etu.labs.Enums.MotherBoards.MotherBoardsBrands;
import com.etu.labs.Enums.RAM.RAMBrands;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRAM extends AddTemplate{
    private JComboBox<RAMBrands> comboRAMBrands;
    private JComboBox<RAMTypes> comboRAMType;
    private JTextField fieldFullName;
    private JComboBox<String> comboCapacity;
    private JLabel [] fieldLabels;

    private static final String [] RAM_CAPACITIES = {"1", "2", "4", "8", "16", "32"};
    private static final String [] FIELD_NAMES = {"Бренд", "Тип", "Наименование", "Объём"};
    private static final int NUM_FIELDS = 4;

    public AddRAM(){
        super("Добавление ОЗУ", 275);
        fieldLabels = new JLabel[NUM_FIELDS];

        comboRAMBrands = new JComboBox<RAMBrands>(RAMBrands.values());
        comboRAMType = new JComboBox<RAMTypes>(RAMTypes.values());
        fieldFullName = new JTextField();
        comboCapacity = new JComboBox<String>(RAM_CAPACITIES);

        int currentY = 50;
        for (int i = 0; i < NUM_FIELDS; i++){
            fieldLabels[i] = new JLabel(FIELD_NAMES[i]);
            fieldLabels[i].setBounds(20, currentY, 90, 25);
            add(fieldLabels[i]);
            currentY += 25;
        }

        comboRAMBrands.setBounds(120, 50, 100, 20);
        comboRAMType.setBounds(120, 75, 100, 20);
        fieldFullName.setBounds(120, 100, 100, 20);
        comboCapacity.setBounds(120, 125, 100, 20);

        add(comboRAMBrands);
        add(comboRAMType);
        add(fieldFullName);
        add(comboCapacity);

        super.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenericDB<RandomAccessMemory> motherBoardsDB = new GenericDB<>(RandomAccessMemory.class);
                RandomAccessMemory newRAM = new RandomAccessMemory((RAMBrands) comboRAMBrands.getSelectedItem(), (RAMTypes) comboRAMType.getSelectedItem(), fieldFullName.getText(), Integer.parseInt(comboCapacity.getSelectedItem().toString()));
                motherBoardsDB.create(newRAM);
            }
        });
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new AddRAM());
    }
}
