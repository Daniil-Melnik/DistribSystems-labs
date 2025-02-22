package com.etu.labs.GUI.DialogWindows;

import com.etu.labs.Enums.Util.ErrorCodes;

import javax.swing.*;
import java.util.ArrayList;

public class Messages {
    public static void showBadMessage(ArrayList<ErrorCodes> errorCodes){
        String msg = "";
        for (ErrorCodes eC : errorCodes) { msg += eC.getDescription() + "\n";}
        JOptionPane.showMessageDialog(null, msg, "Проблема", JOptionPane.ERROR_MESSAGE);
    }
}
