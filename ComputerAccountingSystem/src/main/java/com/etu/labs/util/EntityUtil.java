package com.etu.labs.util;

import com.etu.labs.Computer;
import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.ComputerElements.ProcessorUnit;
import com.etu.labs.ComputerElements.RandomAccessMemory;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Util.ErrorCodes;

import java.util.ArrayList;

public class EntityUtil {

    private static final int NUM_CODES = 6;

    private static ErrorCodes checkDiskMB(HardDrive disk, MotherBoard motherBoard){
        return (!(((disk.getConnectorType() == DiskConnector.M_2) && (motherBoard.getNumM2() == 0))
                || ((disk.getConnectorType() == DiskConnector.SATA) && (motherBoard.getNumSATA() == 0))))
                ? ErrorCodes.DISK_CONNECTOR : ErrorCodes.PERFECT;
    }

    private static ErrorCodes checkCpuSocket(ProcessorUnit cpu, MotherBoard moteherBoard){
        return (cpu.getSocketType() != moteherBoard.getSocketType()) ? ErrorCodes.PROCESSOR_SOCKET : ErrorCodes.PERFECT;
    }

    private static ErrorCodes checkCpuRam(ProcessorUnit cpu, RandomAccessMemory ram){
        return (cpu.getRamType() != ram.getType()) ? ErrorCodes.RAM_TYPE_CPU : ErrorCodes.PERFECT;
    }

    private static ErrorCodes checkMbRam(MotherBoard mb, RandomAccessMemory ram){
        return (mb.getRamType() != ram.getType()) ? ErrorCodes.RAM_TYPE_MB : ErrorCodes.PERFECT;
    }

    private static ErrorCodes checkNumRam(MotherBoard mb, int num){
        return (mb.getNumRAM() < num) ? ErrorCodes.NUM_RAM : ErrorCodes.PERFECT;
    }

    public static boolean checkComuter(Computer pc){
        boolean code = true;
        ArrayList<ErrorCodes> errorCodes = new ArrayList<>();
        ErrorCodes errorCode;
        if ((errorCode = checkCpuRam(pc.getPcCPU(), pc.getPcRAM())) != ErrorCodes.PERFECT){
            errorCodes.add(errorCode);
        }

        if ((errorCode = checkCpuSocket(pc.getPcCPU(), pc.getPcMotherBoard())) != ErrorCodes.PERFECT){
            errorCodes.add(errorCode);
        }

        if ((errorCode = checkDiskMB(pc.getPcDisk(), pc.getPcMotherBoard())) != ErrorCodes.PERFECT){
            errorCodes.add(errorCode);
        }

        if ((errorCode = checkMbRam(pc.getPcMotherBoard(), pc.getPcRAM())) != ErrorCodes.PERFECT){
            errorCodes.add(errorCode);
        }

        if ((errorCode = checkNumRam(pc.getPcMotherBoard(), pc.getNumOfRAM())) != ErrorCodes.PERFECT){
            errorCodes.add(errorCode);
        }
        return code;
    }
}
