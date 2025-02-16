package com.etu.labs.ComputerElements;

import com.etu.labs.Enums.RAM.RAMBrands;
import com.etu.labs.Enums.RAMTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ram_units")
public class RandomAccesMemory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ram_brand")
    private RAMBrands brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "ram_type")
    private RAMTypes type;

    @Enumerated(EnumType.STRING)
    @Column(name = "ram_name")
    private String fullName;

    @Column(name = "ram_capacity")
    private int capacity;

    public void setId (int newId){ id = newId;}
    public int getId(){ return id;}

    public void setBrand(RAMBrands newBrand){ brand = newBrand;}
    public RAMBrands getBrand(){ return brand;}

    public void setType(RAMTypes newType){ type = newType;}
    public RAMTypes getType(){ return type;}

    public void setFullName(String newFullName){ fullName = newFullName;}
    public String getFullName(){ return  fullName;}

    public void setCapacity(int newCapacity){ capacity = newCapacity;}
    public int getCapacity(){ return capacity;}
}
