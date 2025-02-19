package com.etu.labs.GUI.DialogWindows;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.Enums.Disk.DiskBrands;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Disk.DiskType;
import com.etu.labs.util.GenericDB;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHardDrive extends AddTemplate{

    private static final String [] CAPASITY = {"80", "96", "120", "240", "250", "320", "480", "500", "512", "1000", "1500", "2000", "4000"};
    private static final int N_FIELDS = 6;
    private static  final String [] FIELD_NAMES = {"Бренд", "Наименование", "Объём", "Тип", "Интерфейс", "Год выпуска"};

    private JComboBox<DiskBrands> comboDiskBrand;
    private JComboBox<DiskType> comboDiskType;
    private JComboBox<DiskConnector> comboDiskConnector;
    private JComboBox<String> comboDiskCapasity;
    private JComboBox<String> comboYearProduction;
    private JTextField fieldDiskName;
    private JLabel [] fieldLabels;

    public AddHardDrive(){
        super("Добавление диска");
        String [] years = prepareYears();
        fieldLabels = new JLabel[N_FIELDS];

        comboDiskBrand = new JComboBox<DiskBrands>(DiskBrands.values());
        comboDiskType = new JComboBox<DiskType>(DiskType.values());
        comboDiskConnector = new JComboBox<DiskConnector>(DiskConnector.values());
        comboDiskCapasity = new JComboBox<String>(CAPASITY);
        comboYearProduction = new JComboBox<String>(years);
        fieldDiskName = new JTextField();

        comboDiskBrand.setBounds(120, 75, 100, 20);
        fieldDiskName.setBounds(120, 100, 100, 20);
        comboDiskCapasity.setBounds(120, 125, 100, 20);
        comboDiskType.setBounds(120, 150, 100, 20);
        comboDiskConnector.setBounds(120, 175, 100, 20);
        comboYearProduction.setBounds(120, 200, 100, 20);

        int currentY = 75;

        for (int i = 0; i < N_FIELDS; i++){
            fieldLabels[i] = new JLabel(FIELD_NAMES[i]);
            fieldLabels[i].setBounds(20, currentY, 90, 25);
            add(fieldLabels[i]);
            currentY += 25;
        }

        add(comboDiskBrand);
        add(comboDiskType);
        add(comboDiskConnector);
        add(comboDiskCapasity);
        add(comboYearProduction);
        add(fieldDiskName);

        super.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenericDB<HardDrive> hardDriveDB = new GenericDB<>(HardDrive.class);
                HardDrive newHardDrive = new HardDrive((DiskBrands) comboDiskBrand.getSelectedItem(), Integer.parseInt((String) comboYearProduction.getSelectedItem()), Integer.parseInt((String) comboDiskCapasity.getSelectedItem()), (DiskType) comboDiskType.getSelectedItem(), (DiskConnector) comboDiskConnector.getSelectedItem(), fieldDiskName.getText());
                hardDriveDB.create(newHardDrive);
            }
        });
    }
    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new AddHardDrive());
    }

    private String [] prepareYears(){
        String [] years = new String[31];
        for (int i = 1995; i < 2026; i++){
            years[i - 1995] = Integer.toString(i);
        }
        return years;
    }
}
