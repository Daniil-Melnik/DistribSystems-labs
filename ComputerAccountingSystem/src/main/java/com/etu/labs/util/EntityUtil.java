package com.etu.labs.util;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.ComputerElements.RandomAccessMemory;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Util.ErrorCodes;

public class EntityUtil {
    public static ErrorCodes checkDiskMB(HardDrive disk, MotherBoard motherBoard){
        return (!(((disk.getConnectorType() == DiskConnector.M_2) && (motherBoard.getNumM2() == 0))
                || ((disk.getConnectorType() == DiskConnector.SATA) && (motherBoard.getNumSATA() == 0))))
                ? ErrorCodes.DISK_CONNECTOR : ErrorCodes.PERFECT;
    }

    public static ErrorCodes checkCpuSocket(ProcessorUnit cpu, MotherBoard moteherBoard){
        return (cpu.getSocketType() != moteherBoard.getSocketType()) ? ErrorCodes.PROCESSOR_SOCKET : ErrorCodes.PERFECT;
    }

    public static ErrorCodes checkCpuRam(ProcessorUnit cpu, RandomAccessMemory ram){
        return (cpu.getRamType() != ram.getType()) ? ErrorCodes.RAM_TYPE_CPU : ErrorCodes.PERFECT;
    }

    public static ErrorCodes checkMbRam(MotherBoard mb, RandomAccessMemory ram){
        return (mb.getRamType() != ram.getType()) ? ErrorCodes.RAM_TYPE_MB : ErrorCodes.PERFECT;
    }

    public static ErrorCodes checkNumRam(MotherBoard mb, int num){
        return (mb.getNumRAM() < num) ? ErrorCodes.NUM_RAM : ErrorCodes.PERFECT;
    }
}
