package com.etu.labs.GUI.DialogWindows.AddUpdate;

import com.etu.labs.Computer;
import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.ComputerElements.RandomAccessMemory;
import com.etu.labs.Enums.CPUs.CPUBrands;
import com.etu.labs.Enums.CPUs.CPUSeries;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;
import com.etu.labs.Enums.Util.ErrorCodes;
import com.etu.labs.GUI.DialogWindows.AddTemplate;
import com.etu.labs.GUI.DialogWindows.Messages;
import com.etu.labs.util.EntityUtil;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddComputer extends AddTemplate {

    private JComboBox<String> comboHardDrive;
    private JComboBox<String> comboCPU;
    private JComboBox<String> comboRAM;
    private JComboBox<String> comboMB;
    private JComboBox<String> comboNumRAM;
    private JTextField fieldInvNum;
    private JLabel [] fieldLabels;

    private static final String [] NUMS_RAM = {"1", "2", "4"};
    private static final String [] FIELD_LABELS = {"Диск", "Мат. плата", "ОЗУ", "ЦПУ", "Кол-во ОЗУ", "Инв. №"};

    private static final int NUM_FIELDS = 6;

    public AddComputer(){
        super("Добавление ПК", 350, 325);
        fieldLabels = new JLabel[NUM_FIELDS];
        GenericDB<HardDrive> hardDriveDB = new GenericDB<HardDrive>(HardDrive.class);
        GenericDB<MotherBoard> motherBoardDB = new GenericDB<MotherBoard>(MotherBoard.class);
        GenericDB<ProcessorUnit> processorUnitDB = new GenericDB<ProcessorUnit>(ProcessorUnit.class);
        GenericDB<RandomAccessMemory> ramDB = new GenericDB<RandomAccessMemory>(RandomAccessMemory.class);

        List<HardDrive> hdL = hardDriveDB.readAll();
        List<MotherBoard> mbL = motherBoardDB.readAll();
        List<ProcessorUnit> cpuL = processorUnitDB.readAll();
        List<RandomAccessMemory> ramL = ramDB.readAll();

        int currentY = 50;

        for (int i = 0; i < NUM_FIELDS; i++){
            fieldLabels[i] = new JLabel(FIELD_LABELS[i]);
            fieldLabels[i].setBounds(20, currentY, 90, 25);
            add(fieldLabels[i]);
            currentY += 25;
        }

        comboHardDrive = new JComboBox<>(toComboList(hdL));
        comboMB = new JComboBox<>(toComboList(mbL));
        comboCPU = new JComboBox<>(toComboList(cpuL));
        comboRAM = new JComboBox<>(toComboList(ramL));
        comboNumRAM = new JComboBox<>(NUMS_RAM);
        fieldInvNum = new JTextField();

        comboHardDrive.setBounds(120, 50, 200, 20);
        comboMB.setBounds(120, 75, 200, 20);
        comboRAM.setBounds(120, 100, 200, 20);
        comboCPU.setBounds(120, 125, 200, 20);
        comboNumRAM.setBounds(120, 150, 100, 20);
        fieldInvNum.setBounds(120, 175, 100, 20);

        add(comboHardDrive);
        add(comboMB);
        add(comboRAM);
        add(comboCPU);
        add(comboNumRAM);
        add(fieldInvNum);

        super.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenericDB<Computer> pcDB = new GenericDB<>(Computer.class);
                Computer newComputer = new Computer(hdL.get(comboHardDrive.getSelectedIndex()), mbL.get(comboMB.getSelectedIndex()), cpuL.get(comboCPU.getSelectedIndex()), ramL.get(comboRAM.getSelectedIndex()), Integer.parseInt(fieldInvNum.getText()), Integer.parseInt(comboNumRAM.getSelectedItem().toString()));
                ArrayList<ErrorCodes> eC = EntityUtil.checkComuter(newComputer);
                if (eC.size() != 0) {
                    Messages.showBadMessage(eC);
                }
                else {
                    pcDB.create(newComputer);
                }
            }
        });
    }

    public static <T> String[] toComboList(List<T> list) {
        return list.stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new AddComputer());
    }
}
