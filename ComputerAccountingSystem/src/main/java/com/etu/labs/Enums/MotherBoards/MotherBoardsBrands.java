package com.etu.labs.Enums.MotherBoards;

public enum MotherBoardsBrands {
    ASUS("Asus"),
    ASROCK("ASRock"),
    GIGABYTE("Gigabyte"),
    INTEL("Intel");

    private String mbBrandName;
    MotherBoardsBrands(String str){
        mbBrandName = str;
    }

    public String getDescription(){
        return  mbBrandName;
    };
}
