package com.etu.labs.GUI.DialogWindows.AddUpdate;

import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.Enums.MotherBoards.MotherBoardsBrands;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;
import com.etu.labs.GUI.DialogWindows.AddTemplate;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMotherBoard extends AddTemplate {
    private JTextField fieldFullName;
    private JComboBox<MotherBoardsBrands> comboMBBrand;
    private JComboBox<Sockets> comboSockets;
    private JComboBox<RAMTypes> comboRAMTypes;
    private JComboBox<String> comboNumPCI;
    private JComboBox<String> comboNumRAM;
    private JComboBox<String> comboNumSATA;
    private JComboBox<String> comboNumM_2;
    private JLabel [] labelsField;

    private static final String [] NUM_RAM_PCI_VARIANTS = {"0", "1", "2", "3", "4"};
    private static final String [] NUM_SATA_VARIANTS = {"0", "1", "2", "3", "4", "5", "6"};
    private static final String [] FIELD_NAMES = {"Наименование", "Бренд", "Сокет", "Тип ОЗУ", "Кол-во PCIe", "Кол-во ОЗУ", "Кол-во SATA", "Кол-во M_2"};

    private static final int NUM_FIELDS = 8;

    public AddMotherBoard(){
        super("Добавление МП", 250, 325);
        labelsField = new JLabel[NUM_FIELDS];

        fieldFullName = new JTextField();
        comboMBBrand = new JComboBox<MotherBoardsBrands>(MotherBoardsBrands.values());
        comboSockets = new JComboBox<Sockets>(Sockets.values());
        comboRAMTypes = new JComboBox<RAMTypes>(RAMTypes.values());
        comboNumPCI = new JComboBox<String>(NUM_RAM_PCI_VARIANTS);
        comboNumRAM = new JComboBox<String>(NUM_RAM_PCI_VARIANTS);
        comboNumSATA = new JComboBox<String>(NUM_SATA_VARIANTS);
        comboNumM_2 = new JComboBox<String>(NUM_RAM_PCI_VARIANTS);

        int currentY = 50;
        for (int i = 0; i < NUM_FIELDS; i++){
            labelsField[i] = new JLabel(FIELD_NAMES[i]);
            labelsField[i].setBounds(20, currentY, 90, 25);
            add(labelsField[i]);
            currentY += 25;
        }

        fieldFullName.setBounds(120, 50, 100, 20);
        comboMBBrand.setBounds(120, 75, 100, 20);
        comboSockets.setBounds(120, 100, 100, 20);
        comboRAMTypes.setBounds(120, 125, 100, 20);
        comboNumPCI.setBounds(120, 150, 100, 20);
        comboNumRAM.setBounds(120, 175, 100, 20);
        comboNumSATA.setBounds(120, 200, 100, 20);
        comboNumM_2.setBounds(120, 225, 100, 20);

        add(fieldFullName);
        add(comboMBBrand);
        add(comboSockets);
        add(comboRAMTypes);
        add(comboNumPCI);
        add(comboNumRAM);
        add(comboNumSATA);
        add(comboNumM_2);

        super.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenericDB<MotherBoard> motherBoardsDB = new GenericDB<>(MotherBoard.class);
                MotherBoard newMotherBoard = new MotherBoard((MotherBoardsBrands) comboMBBrand.getSelectedItem(),
                        fieldFullName.getText(),
                        (Sockets) comboSockets.getSelectedItem(),
                        (RAMTypes) comboRAMTypes.getSelectedItem(),
                        Integer.parseInt(comboNumPCI.getSelectedItem().toString()),
                        Integer.parseInt(comboNumRAM.getSelectedItem().toString()),
                        Integer.parseInt(comboNumSATA.getSelectedItem().toString()),
                        Integer.parseInt(comboNumM_2.getSelectedItem().toString()));
                motherBoardsDB.create(newMotherBoard);
            }
        });
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new AddMotherBoard());
    }
}
