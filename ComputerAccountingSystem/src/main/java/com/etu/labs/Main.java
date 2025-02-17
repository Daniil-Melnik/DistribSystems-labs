package com.etu.labs;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.DBUtils.GenericDB;
import com.etu.labs.Enums.Disk.DiskBrands;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Disk.DiskType;
import com.etu.labs.Enums.MotherBoards.MotherBoardsBrands;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;

public class Main {
    public static void main(String [] args){
        GenericDB<HardDrive> hardDriveDB = new GenericDB<>(HardDrive.class);
        HardDrive newDisk = new HardDrive(DiskBrands.SEAGATE, 2019, 1000, DiskType.HDD, DiskConnector.SATA);
        hardDriveDB.create(newDisk);

        GenericDB<MotherBoard> motherBoardDB = new GenericDB<>(MotherBoard.class);
        MotherBoard motherBoard = new MotherBoard(MotherBoardsBrands.ASROCK, "A520M-HVS", Sockets.AM4, RAMTypes.DDR4, 1, 2);
        motherBoardDB.create(motherBoard);
    }
}
