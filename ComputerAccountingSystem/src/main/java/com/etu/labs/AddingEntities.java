package com.etu.labs;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.ComputerElements.RandomAccessMemory;
import com.etu.labs.Enums.CPUs.CPUBrands;
import com.etu.labs.Enums.CPUs.CPUSeries;
import com.etu.labs.Enums.Disk.DiskBrands;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Disk.DiskType;
import com.etu.labs.Enums.MotherBoards.MotherBoardsBrands;
import com.etu.labs.Enums.RAM.RAMBrands;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;
import com.etu.labs.util.GenericDB;

public class AddingEntities {
    public static void addEntities(){
        GenericDB<HardDrive> hardDriveDB = new GenericDB<>(HardDrive.class);
        GenericDB<MotherBoard> motherBoardDB = new GenericDB<>(MotherBoard.class);
        GenericDB<ProcessorUnit> processorUnitsDB = new GenericDB<>(ProcessorUnit.class);
        GenericDB<RandomAccessMemory> randomAccesMemoryDB = new GenericDB<>(RandomAccessMemory.class);
        GenericDB<Computer> computerDB = new GenericDB<>(Computer.class);

        HardDrive newDisk = new HardDrive(DiskBrands.SEAGATE, 2019, 1000, DiskType.HDD, DiskConnector.SATA, "ST1000DM010");
        hardDriveDB.create(newDisk);

        newDisk = new HardDrive(DiskBrands.CRUCIAL, 2024, 500, DiskType.SSD, DiskConnector.M_2, "P3 CT500P3SSD8");
        hardDriveDB.create(newDisk);

        newDisk = new HardDrive(DiskBrands.WD, 2023, 1000, DiskType.HDD, DiskConnector.SATA, "WD10EZEX");
        hardDriveDB.create(newDisk);

        MotherBoard motherBoard = new MotherBoard(MotherBoardsBrands.ASROCK, "A520M-HVS", Sockets.AM4, RAMTypes.DDR4, 1, 2, 4, 0);
        motherBoardDB.create(motherBoard);

        motherBoard = new MotherBoard(MotherBoardsBrands.ASUS, "H81M-K", Sockets.LGA1150, RAMTypes.DDR3, 1, 2, 4, 0);
        motherBoardDB.create(motherBoard);

        motherBoard = new MotherBoard(MotherBoardsBrands.MSI, "PRO B760-P WIFI DDR4", Sockets.LGA1700, RAMTypes.DDR4, 5, 2, 4, 2);
        motherBoardDB.create(motherBoard);

        ProcessorUnit processorUnit = new ProcessorUnit(Sockets.LGA1150, CPUBrands.INTEL, CPUSeries.CORE_I7, "4790", RAMTypes.DDR3);
        processorUnitsDB.create(processorUnit);

        processorUnit = new ProcessorUnit(Sockets.LGA1700, CPUBrands.INTEL, CPUSeries.CORE_I5, "12400", RAMTypes.DDR4);
        processorUnitsDB.create(processorUnit);

        processorUnit = new ProcessorUnit(Sockets.AM4, CPUBrands.AMD, CPUSeries.RYZEN_5, "5500", RAMTypes.DDR4);
        processorUnitsDB.create(processorUnit);

        RandomAccessMemory newRAM = new RandomAccessMemory(RAMBrands.KINGSTON, RAMTypes.DDR4, "KF432C16BBK2", 16);
        randomAccesMemoryDB.create(newRAM);

        Computer newPC = new Computer(hardDriveDB.read(2), motherBoardDB.read(3), processorUnitsDB.read(2), randomAccesMemoryDB.read(1), 2614, 2);
        computerDB.create(newPC);
    }
}
