package com.etu.labs.Enums.CPUs;

public enum CPUBrands {
    AMD ("AMD"),
    INTEL("Intel");

    private String description;
    CPUBrands(String str){
        description = str;
    }

    public String getDescription(){
        return description;
    }
}
