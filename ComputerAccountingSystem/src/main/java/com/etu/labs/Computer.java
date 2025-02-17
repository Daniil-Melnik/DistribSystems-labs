package com.etu.labs;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.ComputerElements.RandomAccesMemory;

public class Computer {
    private HardDrive pcDisk;
    private MotherBoard pcMotherBoard;
    private ProcessorUnit pcCPU;
    private RandomAccesMemory pcRAM;
    private int inventoryNumber;

    public void setPcDisk(HardDrive newPcDisk){ pcDisk = newPcDisk;}
    public HardDrive getPcDisk(){ return  pcDisk;}

    public void setPcMotherBoard(MotherBoard newPcMotherBoard){ pcMotherBoard = newPcMotherBoard;}
    public MotherBoard getPcMotherBoard(){ return pcMotherBoard;}

    public void setPcCPU(ProcessorUnit newPcCPU){ pcCPU = newPcCPU;}
    public ProcessorUnit getPcCPU(){ return pcCPU;}

    public void setPcRAM(RandomAccesMemory newPcRAM){ pcRAM = newPcRAM;}
    public RandomAccesMemory getPcRAM(){ return  pcRAM;}

    public void setInventoryNumber(int newInventoryNumber){ inventoryNumber = newInventoryNumber;}
    public int getInventoryNumber(){ return  inventoryNumber;}

    public Computer(){}

    public Computer(HardDrive pcDisk, MotherBoard pcMotherBoard, ProcessorUnit pcCPU, RandomAccesMemory pcRAM, int inventoryNumber){
        setPcCPU(pcCPU);
        setInventoryNumber(inventoryNumber);
        setPcDisk(pcDisk);
        setPcMotherBoard(pcMotherBoard);
        setPcRAM(pcRAM);
    }
}
