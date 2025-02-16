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
@Table(name = "hard_drives")
public class HardDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "hdd_brand")
    private DiskBrands brand;

    @Column(name = "hdd_year_of_product")
    private int yearOfProduct;

    @Column(name = "hdd_capacity")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "hdd_type")
    private DiskType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "hdd_connector_type")
    private DiskConnector connectorType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiskBrands getBrand() {
        return brand;
    }

    public void setBrand(DiskBrands brand) {
        this.brand = brand;
    }

    public int getYearOfProduct() {
        return yearOfProduct;
    }

    public void setYearOfProduct(int yearOfProduct) {
        this.yearOfProduct = yearOfProduct;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DiskType getType() {
        return type;
    }

    public void setType(DiskType type) {
        this.type = type;
    }

    public DiskConnector getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(DiskConnector connectorType) {
        this.connectorType = connectorType;
    }

    public HardDrive(){}

    public  HardDrive(int id, DiskBrands diskBrand, int yearOfProduct, int capacity, DiskType diskType, DiskConnector connectorType){
        setId(id);
        setBrand(diskBrand);
        setYearOfProduct(yearOfProduct);
        setCapacity(capacity);
        setType(diskType);
        setConnectorType(connectorType);
    }
}