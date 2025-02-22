package com.etu.labs.Enums.Util;

public enum ErrorCodes {
    PERFECT("Хорошо"),
    PROCESSOR_SOCKET("Не подходит сокет"),
    RAM_TYPE_CPU("не подходи ОЗУ к ЦПУ"),
    RAM_TYPE_MB("не подходить ОЗУ к МП"),
    DISK_CONNECTOR("не подходит диск к МП"),
    NUM_RAM("много ОЗУ");

    private String description;

    ErrorCodes(String newDescription){
        description = newDescription;
    }

    public String getDescription(){ return description;}
}
