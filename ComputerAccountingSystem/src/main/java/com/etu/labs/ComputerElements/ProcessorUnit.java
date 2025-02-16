package com.etu.labs.ComputerElements;

import com.etu.labs.Enums.CPUs.CPUBrands;
import com.etu.labs.Enums.CPUs.CPUSeries;
import com.etu.labs.Enums.Sockets;

public class ProcessorUnit {
    private int id;
    private Sockets socketType;
    private CPUBrands cpuBrand;
    private CPUSeries cpuSeries;
    private String fullName;

    public void setId(int newId){ id = newId;}
    public int getId(){ return id;}

    public void setSocketType(Sockets newSocketType){ socketType = newSocketType;}
    public Sockets getSocketType(){ return  socketType;}

    public void setCpuBrand (CPUBrands newCPUBrand) { cpuBrand = newCPUBrand;}
    public CPUBrands getCpuBrand(){ return cpuBrand;}

    public void setCpuSeries(CPUSeries newCPUSeries){cpuSeries = newCPUSeries;}
    public  CPUSeries getCpuSeries(){ return cpuSeries;}

    public void setFullName(String newFullName){ fullName = newFullName;}
    public String getFullName(){ return fullName;}

    public ProcessorUnit(){}
    public ProcessorUnit(int id, Sockets socketType, CPUBrands cpuBrand, CPUSeries cpuSeries, String fullName){
        setId(id);
        setSocketType(socketType);
        setCpuBrand(cpuBrand);
        setCpuSeries(cpuSeries);
        setFullName(fullName);
    }
}
