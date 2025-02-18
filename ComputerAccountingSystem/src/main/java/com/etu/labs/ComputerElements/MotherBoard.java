package com.etu.labs.ComputerElements;

import com.etu.labs.Enums.MotherBoards.MotherBoardsBrands;
import com.etu.labs.Enums.RAMTypes;
import com.etu.labs.Enums.Sockets;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "mother_boards")
public class MotherBoard {
    @Id
    @Column(name = "mb_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "mb_brand")
    private MotherBoardsBrands MBBrand;

    @Column(name = "mb_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "mb_socket")
    private Sockets socketType;

    @Enumerated(EnumType.STRING)
    @Column(name = "mb_ram_type")
    private RAMTypes ramType;

    @Column(name = "mb_num_pcie")
    private int numPCIe;

    @Column(name = "mb_num_ram")
    private int numRAM;

    @Column(name = "mb_num_m2")
    private int numM2;

    @Column(name = "mb_num_sata")
    private int numSATA;

    public void setId(int newId){id = newId;}
    public int getId(){ return id;}

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

    public void setNumM2(int newNumM2){ numM2 = newNumM2;}
    public int getNumM2(){ return numM2;}

    public void setNumSATA(int newNumSATA){ numSATA = newNumSATA;}
    public int getNumSATA(){ return numSATA;}

    public MotherBoard(){}

    public MotherBoard(MotherBoardsBrands MBBrand, String fullName, Sockets socketType, RAMTypes ramType,
                       int numPCIe, int numRAM, int numSATA, int numM2){
        setMBBrand(MBBrand);
        setFullName(fullName);
        setSocketType(socketType);
        setRamType(ramType);
        setNumPCIe(numPCIe);
        setNumRAM(numRAM);
        setNumM2(numM2);
        setNumSATA(numSATA);
    }
}
