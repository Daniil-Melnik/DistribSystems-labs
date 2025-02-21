package com.etu.labs.util;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.ComputerElements.MotherBoard;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Util.DiskCodes;

public class EntityUtil {
    public static DiskCodes checkDiskMB(HardDrive disk, MotherBoard motherBoard){
        DiskCodes code = DiskCodes.PERFECT;
        if (!(((disk.getConnectorType() == DiskConnector.M_2) && (motherBoard.getNumM2() == 0))
                || ((disk.getConnectorType() == DiskConnector.SATA) && (motherBoard.getNumSATA() == 0)))){
            code = DiskCodes.DISK_CONNECTOR;
        }
        return code;
    }
}
