package com.etu.labs.GUI.Windows;

import com.etu.labs.Computer;
import com.etu.labs.GUI.DialogWindows.AddUpdate.AddComputer;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ComputerWindow extends WindowTemplate{
    private JButton addBtn;
    private JButton delBtn;
    private JButton updBtn;

    private static final int COLUMN_NUM = 6;
    private final String [] TABLE_HEAD = {"id", "инв. №", "Мат. плата", "ЦПУ", "ОЗУ", "кол-во ОЗУ"};

    public ComputerWindow(){
        super("Компьютеры",  "", 600, 250);
        GenericDB<Computer> pcDB = new GenericDB<Computer>(Computer.class);
        String[][] rowsTable = toTableArr(pcDB.readAll());

        addBtn = new JButton("+");
        addBtn.setBounds(535, 185, 50, 27);
        add(addBtn);

        delBtn = new JButton("-");
        delBtn.setBounds(480, 185, 50, 27);
        add(delBtn);

        updBtn = new JButton("изм");
        updBtn.setBounds(425, 185, 50, 27);
        add(updBtn);

        for (String str : TABLE_HEAD){ super.model.addColumn(str);}
        for (String[] strings : rowsTable) { super.model.addRow(strings);}

        super.revalidate();

        super.table.getColumnModel().getColumn(0).setPreferredWidth(20);
        super.table.getColumnModel().getColumn(1).setPreferredWidth(20);
        super.table.getColumnModel().getColumn(5).setPreferredWidth(20);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddComputer addPC = new AddComputer(ComputerWindow.this);
                addPC.setVisible(true);
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = ComputerWindow.super.table.getSelectedRow();
                GenericDB<Computer> computerDB = new GenericDB<>(Computer.class);
                computerDB.delete(Integer.parseInt(ComputerWindow.super.table.getValueAt(selectedRow, 0).toString()));
                refreshTable();
            }
        });
    }

    public void addComputer(Computer newPC){
        GenericDB<Computer> computerDB = new GenericDB<>(Computer.class);
        computerDB.create(newPC);
        refreshTable();

    }

    private void refreshTable(){
        GenericDB<Computer> computerDB = new GenericDB<Computer>(Computer.class);
        String[][] rowsTable = toTableArr(computerDB.readAll());

        super.model.setRowCount(0);
        for (String[] strings : rowsTable) { super.model.addRow(strings);}
        super.revalidate();
    }

    private String [][] toTableArr(List<Computer> list){
        String [][] res = new String[list.size()][COLUMN_NUM];

        for (int i = 0; i < list.size(); i++){
            Computer pc = list.get(i);
            res[i] = new String[] {Integer.toString(pc.getId()), Integer.toString(pc.getInventoryNumber()), pc.getPcMotherBoard().getFullName(), pc.getPcCPU().getCpuSeries() + pc.getPcCPU().getFullName(), pc.getPcRAM().getFullName(), Integer.toString(pc.getNumOfRAM())};
        }
        return res;
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new ComputerWindow());
    }
}
