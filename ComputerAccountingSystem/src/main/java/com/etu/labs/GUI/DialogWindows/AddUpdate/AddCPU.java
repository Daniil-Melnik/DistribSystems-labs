package com.etu.labs.GUI.DialogWindows.AddUpdate;

import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.Enums.CPUs.CPUBrands;
import com.etu.labs.Enums.CPUs.CPUSeries;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;
import com.etu.labs.GUI.Windows.CpuWindow;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCPU extends AddTemplate {

    private JComboBox<CPUBrands> comboCPUBrand;
    private JComboBox<CPUSeries> comboCPUSeries;
    private JComboBox<RAMTypes> comboCPURAMType;
    private JComboBox<Sockets> comboSocketType;
    private JTextField fieldCPUName;

    private JLabel [] labelsField;

    private final static String [] FIELD_LABELS = {"Бренд", "Серия", "Тип ОЗУ", "Наименование", "Сокет"};
    private final static int NUM_LABELS = 5;

    public AddCPU(CpuWindow parent){
        super("Добавление ЦПУ", 250, 300);

        labelsField = new JLabel[NUM_LABELS];
        comboCPUBrand = new JComboBox<CPUBrands>(CPUBrands.values());
        comboCPUSeries = new JComboBox<CPUSeries>(CPUSeries.values());
        comboCPURAMType = new JComboBox<RAMTypes>(RAMTypes.values());
        comboSocketType = new JComboBox<Sockets>(Sockets.values());
        fieldCPUName = new JTextField();

        comboCPUBrand.setBounds(120, 75, 100, 20);
        comboCPUSeries.setBounds(120, 100, 100, 20);
        comboCPURAMType.setBounds(120, 125, 100, 20);
        fieldCPUName.setBounds(120, 150, 100, 20);
        comboSocketType.setBounds(120, 175, 100, 20);

        add(comboCPUBrand);
        add(comboCPUSeries);
        add(comboCPURAMType);
        add(fieldCPUName);
        add(comboSocketType);

        int currentY = 75;

        for (int i = 0; i < NUM_LABELS; i++){
            labelsField[i] = new JLabel(FIELD_LABELS[i]);
            labelsField[i].setBounds(20, currentY, 90, 25);
            add(labelsField[i]);
            currentY += 25;
        }

        super.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProcessorUnit newProcessorUnit = new ProcessorUnit((Sockets) comboSocketType.getSelectedItem(), (CPUBrands) comboCPUBrand.getSelectedItem(), (CPUSeries) comboCPUSeries.getSelectedItem(), fieldCPUName.getText(), (RAMTypes) comboCPURAMType.getSelectedItem());
                dispose();
                parent.addCPU(newProcessorUnit);
            }
        });
    }
}
