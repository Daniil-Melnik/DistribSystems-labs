package com.etu.labs.GUI.Windows;

import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.Enums.CPUs.CPUBrands;
import com.etu.labs.GUI.DialogWindows.AddUpdate.AddCPU;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class CpuWindow extends WindowTemplate{
    private JComboBox<CPUBrands> comboBrands;
    private JButton addBtn;
    private JButton delBtn;

    private final String [] TABLE_HEAD = {"id", "производитель", "серия", "наименование", "сокет", "ОЗУ"};
    private static final int COLUMN_NUM = 6;

    public CpuWindow(){
        super("Процессоры", "по произв-лю", 550, 250);
        GenericDB<ProcessorUnit> cpuDB = new GenericDB<ProcessorUnit>(ProcessorUnit.class);
        String[][] rowsTable = toTableArr(cpuDB.readAll());


        addBtn = new JButton("+");
        addBtn.setBounds(485, 185, 50, 27);
        add(addBtn);

        delBtn = new JButton("-");
        delBtn.setBounds(430, 185, 50, 27);
        add(delBtn);

        comboBrands = new JComboBox<CPUBrands>(CPUBrands.values());
        comboBrands.setBounds(120, 185, 100, 25);
        add(comboBrands);

        for (String str : TABLE_HEAD){ super.model.addColumn(str);}
        for (String[] strings : rowsTable) { super.model.addRow(strings);}

        super.revalidate();

        super.table.getColumnModel().getColumn(0).setPreferredWidth(20);

        comboBrands.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) { // Проверяем, что элемент был выбран
                    CPUBrands selectedItem = (CPUBrands) comboBrands.getSelectedItem();
                    GenericDB<ProcessorUnit> cpuDB = new GenericDB<ProcessorUnit>(ProcessorUnit.class);
                    List<ProcessorUnit> cpuL = cpuDB.readByField("cpuBrand", selectedItem);

                    String [][] newRowsTable = toTableArr(cpuL);
                    CpuWindow.super.model.setRowCount(0);
                    for (String [] strs : newRowsTable){ CpuWindow.super.model.addRow(strs);}
                    CpuWindow.super.revalidate();
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCPU addCPU = new AddCPU(CpuWindow.this);
                addCPU.setVisible(true);
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = CpuWindow.super.table.getSelectedRow();
                GenericDB<ProcessorUnit> processorUnitDB = new GenericDB<>(ProcessorUnit.class);
                processorUnitDB.delete(Integer.parseInt(CpuWindow.super.table.getValueAt(selectedRow, 0).toString()));
                refreshTable();
            }
        });
    }

    public void addCPU(ProcessorUnit newCPU){
        GenericDB<ProcessorUnit> processorUnitDB = new GenericDB<>(ProcessorUnit.class);
        processorUnitDB.create(newCPU);
        refreshTable();

    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new CpuWindow());
    }

    private void refreshTable(){
        GenericDB<ProcessorUnit> cpuDB = new GenericDB<ProcessorUnit>(ProcessorUnit.class);
        String[][] rowsTable = toTableArr(cpuDB.readAll());

        super.model.setRowCount(0);
        for (String[] strings : rowsTable) { super.model.addRow(strings);}
        super.revalidate();
    }

    private String [][] toTableArr(List<ProcessorUnit> list){
        String [][] res = new String[list.size()][COLUMN_NUM];

        for (int i = 0; i < list.size(); i++){
            ProcessorUnit cpu = list.get(i);
            res[i] = new String[] {Integer.toString(cpu.getId()), cpu.getCpuBrand().getDescription(), cpu.getCpuSeries().getDescription(), cpu.getFullName(), cpu.getSocketType().toString(), cpu.getRamType().toString()};
        }
        return res;
    }
}
