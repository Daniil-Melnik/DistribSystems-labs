package com.etu.labs.Enums.CPUs;

public enum CPUSeries {
    CORE ("core 2"),
    CORE_I3 ("core i3"),
    CORE_I5 ("core i5"),
    CORE_I7 ("core i7"),
    PENTIUM ("Pentium"),
    RYZEN ("Ryzen"),
    RYZEN_5 ("Ryzen 5"),
    RYZEN_7 ("Ryzen 7"),
    RYZEN_9 ("Ryzen 9");

    private  String seriesName;

    CPUSeries(String str){
        seriesName = str;
    }

    public String getDescription(){
        return  seriesName;
    }

    @Override
    public String toString(){ return seriesName;}
}
