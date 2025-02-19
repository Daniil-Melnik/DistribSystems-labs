package com.etu.labs.Enums.Disk;

public enum DiskBrands {

    SAMSUNG("Samsung"),
    SEAGATE("Seagate"),
    KINGSTON("Kingston"),
    KINGSPEC("Kingspec"),
    PATRIOT("Patriot"),
    ADATA("ADATA"),
    AMD("AMD"),
    TRANSCEND("Transcend"),
    WD("Western Digital"),
    CRUCIAL("Crucial"),
    TOSHIBA("Toshiba");

    private String brandTitle;

    DiskBrands(String str){
        brandTitle = str;
    }

    public String getDescription(){
        return brandTitle;
    }

    @Override
    public String toString(){ return brandTitle;}
}
