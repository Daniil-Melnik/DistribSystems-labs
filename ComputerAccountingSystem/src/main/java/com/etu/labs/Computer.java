package com.etu.labs;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.ComputerElements.RandomAccessMemory;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_number")
    private int inventoryNumber;

    @OneToOne
    @JoinColumn(name = "disk_pc_id", referencedColumnName = "disk_id")
    private HardDrive pcDisk;

    @OneToOne
    @JoinColumn(name = "mb_pc_id", referencedColumnName = "mb_id")
    private MotherBoard pcMotherBoard;

    @OneToOne
    @JoinColumn(name = "cpu_pc_id", referencedColumnName = "cpu_id")
    private ProcessorUnit pcCPU;

    @OneToOne
    @JoinColumn(name = "ram_pc_id", referencedColumnName = "ram_id")
    private RandomAccessMemory pcRAM;

    @Column(name = "pc_num_of_ram")
    private int numOfRAM;

    public void setPcDisk(HardDrive newPcDisk){ pcDisk = newPcDisk;}
    public HardDrive getPcDisk(){ return  pcDisk;}

    public void setPcMotherBoard(MotherBoard newPcMotherBoard){ pcMotherBoard = newPcMotherBoard;}
    public MotherBoard getPcMotherBoard(){ return pcMotherBoard;}

    public void setPcCPU(ProcessorUnit newPcCPU){ pcCPU = newPcCPU;}
    public ProcessorUnit getPcCPU(){ return pcCPU;}

    public void setPcRAM(RandomAccessMemory newPcRAM){ pcRAM = newPcRAM;}
    public RandomAccessMemory getPcRAM(){ return  pcRAM;}

    public void setInventoryNumber(int newInventoryNumber){ inventoryNumber = newInventoryNumber;}
    public int getInventoryNumber(){ return  inventoryNumber;}

    public void setNumOfRAM(int newNumOfRAM){ numOfRAM = newNumOfRAM;}
    public int getNumOfRAM(){ return  numOfRAM;}

    public Computer(){}

    public Computer(HardDrive pcDisk, MotherBoard pcMotherBoard, ProcessorUnit pcCPU, RandomAccessMemory pcRAM, int inventoryNumber, int numOfRAM){
        setPcCPU(pcCPU);
        setInventoryNumber(inventoryNumber);
        setPcDisk(pcDisk);
        setPcMotherBoard(pcMotherBoard);
        setPcRAM(pcRAM);
        setNumOfRAM(numOfRAM);
    }
}
