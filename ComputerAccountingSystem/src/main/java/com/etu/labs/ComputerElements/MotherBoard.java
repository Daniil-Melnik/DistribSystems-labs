package com.etu.labs.ComputerElements;

import com.etu.labs.Enums.MotherBoards.MotherBoardsBrands;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;

public class MotherBoard {
    private MotherBoardsBrands MBBrand;
    private String fullName;
    private Sockets socketType;
    private RAMTypes ramType;
    private int numPCIe;
    private int numRAM;

    public void setMBBrand(MotherBoardsBrands newMBBrand){ MBBrand = newMBBrand;}
    public MotherBoardsBrands getMBBrand(){ return  MBBrand;}

    public void setFullName(String newFullName){ fullName = newFullName;}
    public String getFullName(){ return fullName;}

    public void setSocketType(Sockets newSocketType){ socketType = newSocketType;}
    public Sockets getSocketType(){ return  socketType;}

    public void setRamType(RAMTypes newRAMType){ ramType = newRAMType;}
    public RAMTypes getRamType(){ return  ramType;}

    public void setNumPCIe(int newNumPCIe){ numPCIe = newNumPCIe;}
    public int getNumPCIe(){ return numPCIe;}

    public void setNumRAM (int newNumRAM){ numRAM = newNumRAM;}
    public int getNumRAM(){ return numRAM;}

    public MotherBoard(){}
    public MotherBoard(MotherBoardsBrands MBBrand, String fullName, Sockets socketType, RAMTypes ramType,
                       int numPCIe, int numRAM){
        setMBBrand(MBBrand);
        setFullName(fullName);
        setSocketType(socketType);
        setRamType(ramType);
        setNumPCIe(numPCIe);
        setNumRAM(numRAM);
    }
}
