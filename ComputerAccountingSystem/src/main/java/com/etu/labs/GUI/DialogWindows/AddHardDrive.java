package com.etu.labs.GUI.DialogWindows;

import com.etu.labs.Enums.Disk.DiskBrands;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHardDrive extends AddTemplate{
    private JComboBox<DiskBrands> comboDiskBrand;

    public AddHardDrive(){
        comboDiskBrand = new JComboBox<DiskBrands>(DiskBrands.values());
        comboDiskBrand.setBounds(50, 100, 100, 20);
        add(comboDiskBrand);

        super.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AddHardDrive.this, ((DiskBrands) comboDiskBrand.getSelectedItem()).name());
            }
        });
    }
    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new AddHardDrive());
    }
}
