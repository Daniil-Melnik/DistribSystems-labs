package com.etu.labs.ComputerElements;

import com.etu.labs.Enums.CPUs.CPUBrands;
import com.etu.labs.Enums.CPUs.CPUSeries;
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
@Table(name = "processor_units")
public class ProcessorUnit {
    @Id
    @Column(name = "cpu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cpu_socket")
    private Sockets socketType;

    @Enumerated(EnumType.STRING)
    @Column(name = "cpu_brand")
    private CPUBrands cpuBrand;

    @Enumerated(EnumType.STRING)
    @Column(name = "cpu_series")
    private CPUSeries cpuSeries;

    @Column(name = "cpu_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "cpu_ram")
    private RAMTypes ramType;

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

    public void setRamType(RAMTypes newRamType){ ramType = newRamType;}
    public RAMTypes getRamType(){ return ramType;}

    public ProcessorUnit(){}

    public ProcessorUnit( Sockets socketType, CPUBrands cpuBrand, CPUSeries cpuSeries, String fullName, RAMTypes ramType){
        setSocketType(socketType);
        setCpuBrand(cpuBrand);
        setCpuSeries(cpuSeries);
        setFullName(fullName);
        setRamType(ramType);
    }

    public ProcessorUnit(int id, Sockets socketType, CPUBrands cpuBrand, CPUSeries cpuSeries, String fullName, RAMTypes ramType){
        setId(id);
        setSocketType(socketType);
        setCpuBrand(cpuBrand);
        setCpuSeries(cpuSeries);
        setFullName(fullName);
        setRamType(ramType);
    }
}
