package com.etu.labs;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.util.GenericDB;

import java.util.List;

public class Main {
    public static void main(String [] args){
        GenericDB<HardDrive> computerDB = new GenericDB<>(HardDrive.class);
        List<HardDrive> hdL = computerDB.readByField("connectorType", DiskConnector.SATA);
        for (HardDrive hd : hdL){System.out.println(hd.toString());}
    }
}
