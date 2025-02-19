package com.etu.labs;

import com.etu.labs.util.GenericDB;

public class Main {
    public static void main(String [] args){
        GenericDB<Computer> computerDB = new GenericDB<>(Computer.class);
        System.out.println(computerDB.getAll());
    }
}
