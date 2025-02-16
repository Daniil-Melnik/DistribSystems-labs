package com.etu.labs.Enums.CPUs;

public enum CPUSeries {
    CORE ("core"),
    CORE_I3 ("core i3"),
    CORE_I5 ("core i5"),
    CORE_I7 ("core i7"),
    PENTIUM ("Pentium");

    private  String seriesName;
    CPUSeries(String str){
        seriesName = str;
    }
    public String getDescription(){
        return  seriesName;
    }
}
