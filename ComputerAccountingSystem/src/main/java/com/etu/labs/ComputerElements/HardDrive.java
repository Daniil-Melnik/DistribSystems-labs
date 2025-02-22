package com.etu.labs.ComputerElements;

import com.etu.labs.Enums.Disk.DiskBrands;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Disk.DiskType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "disk_drives")
public class HardDrive {

    @Id
    @Column(name = "disk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "disk_brand")
    private DiskBrands brand;

    @Column(name = "disk_year_of_product")
    private int yearOfProduct;

    @Column(name = "disk_capacity")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "disk_type")
    private DiskType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "disk_connector_type")
    private DiskConnector connectorType;

    @Column(name = "disk_name")
    private String diskName;

    public int getId() { return id;}
    public void setId(int newId) { id = newId;}

    public DiskBrands getBrand() { return brand;}
    public void setBrand(DiskBrands newBrand) { brand = newBrand;}

    public int getYearOfProduct() { return yearOfProduct;}
    public void setYearOfProduct(int newYearOfProduct) { yearOfProduct = newYearOfProduct;}

    public int getCapacity() { return capacity;}
    public void setCapacity(int newCapacity) { capacity = newCapacity;}

    public DiskType getType() { return type;}
    public void setType(DiskType newType) { type = newType;}

    public DiskConnector getConnectorType() { return connectorType;}
    public void setConnectorType(DiskConnector newConnectorType) { connectorType = newConnectorType;}

    public String getDiskName(){ return diskName;}
    public void setDiskName(String newDiskName){ diskName = newDiskName;}

    public HardDrive(){}

    public HardDrive(DiskBrands diskBrand, int yearOfProduct, int capacity, DiskType diskType, DiskConnector connectorType, String diskName){
        setBrand(diskBrand);
        setYearOfProduct(yearOfProduct);
        setCapacity(capacity);
        setType(diskType);
        setConnectorType(connectorType);
        setDiskName(diskName);
    }

    public HardDrive(int id, DiskBrands diskBrand, int yearOfProduct, int capacity, DiskType diskType, DiskConnector connectorType, String diskName){
        setId(id);
        setBrand(diskBrand);
        setYearOfProduct(yearOfProduct);
        setCapacity(capacity);
        setType(diskType);
        setConnectorType(connectorType);
        setDiskName(diskName);
    }

    @Override
    public String toString() {
        return getBrand().toString() + " " + diskName + " " + capacity;
    }
}