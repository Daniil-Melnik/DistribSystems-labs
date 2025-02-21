package com.etu.labs.GUI.DialogWindows;

import javax.swing.*;

public class AddMotherBoard extends AddTemplate{
    public AddMotherBoard(){
        super("Добавление МП");
    }

    public static void main(String [] args){
        SwingUtilities.invokeLater(() -> new AddMotherBoard());
    }
}
