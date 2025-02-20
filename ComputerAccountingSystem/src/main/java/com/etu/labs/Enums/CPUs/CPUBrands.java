package com.etu.labs.Enums.CPUs;

public enum CPUBrands {
    AMD ("AMD"),
    INTEL("Intel");

    private String brandName;
    CPUBrands(String str){
        brandName = str;
    }

    public String getDescription(){
        return brandName;
    }

    @Override
    public String toString(){ return brandName;}

}
