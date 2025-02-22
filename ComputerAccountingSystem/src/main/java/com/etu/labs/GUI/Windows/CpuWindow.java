package com.etu.labs.GUI.Windows;

import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.util.GenericDB;

import javax.swing.*;
import java.util.List;

public class CpuWindow extends WindowTemplate{
    private final String [] TABLE_HEAD = {"id", "производитель", "серия", "наименование", "сокет", "ОЗУ"};
    private static final int COLUMN_NUM = 6;
    public CpuWindow(){
        super("Процессоры", "по произв-лю", 550, 250);
        GenericDB<ProcessorUnit> cpuDB = new GenericDB<ProcessorUnit>(ProcessorUnit.class);
        String[][] rowsTable = toTableArr(cpuDB.readAll());

        for (String str : TABLE_HEAD){ super.model.addColumn(str);}
        for (String[] strings : rowsTable) { super.model.addRow(strings);}

        super.revalidate();
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new CpuWindow());
    }

    private String [][] toTableArr(List<ProcessorUnit> list){
        String [][] res = new String[list.size()][COLUMN_NUM];

        for (int i = 0; i < list.size(); i++){
            ProcessorUnit cpu = list.get(i);
            res[i] = new String[] {Integer.toString(cpu.getId()), cpu.getCpuBrand().getDescription(), cpu.getCpuSeries().getDescription(), cpu.getFullName(), cpu.getSocketType().toString(), cpu.getRamType().toString()};
            System.out.println(Integer.toString(cpu.getId()) + " " + cpu.getCpuBrand().getDescription() + " " + cpu.getCpuSeries().getDescription() + " " + cpu.getFullName() + " " + cpu.getSocketType().toString() + " " + cpu.getRamType().toString());
        }
        return res;
    }
}
