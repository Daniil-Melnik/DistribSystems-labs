package com.etu.labs;

import com.etu.labs.ComputerElements.HardDrive;
import com.etu.labs.Enums.Disk.DiskBrands;
import com.etu.labs.Enums.Disk.DiskConnector;
import com.etu.labs.Enums.Disk.DiskType;
import com.etu.labs.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String [] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            HardDrive hd = new HardDrive();

            hd.setBrand(DiskBrands.AMD);
            hd.setCapacity(1000);
            hd.setType(DiskType.SDD);
            hd.setConnectorType(DiskConnector.M_2);
            hd.setYearOfProduct(2014);
            session.save(hd);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
