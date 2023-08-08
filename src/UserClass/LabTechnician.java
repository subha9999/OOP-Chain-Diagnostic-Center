/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserClass;

import NonUserClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Rahat
 */
public class LabTechnician extends Employee implements Serializable{

    public LabTechnician(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public LabTechnician(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
    }
    
    public static LabTechnician addInstance(String name, int phone, String gender, String branch, LocalDate doB){
        LabTechnician lt = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        
        try {
           // File f = new File("Receptionist.bin");
                       File f = new File("Employee.bin");

            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (LabTechnician) ois.readObject();
                    temp = emp.getId();

                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch     

        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        try {

          //  File f = new File("Receptionist.bin");
                      File f = new File("Employee.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                lt = new LabTechnician(phone, name, gender, branch, "LabTechnician", doB, 30000, "123", temp + 1);
                oos.writeObject(lt);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                lt = new LabTechnician(phone, name, gender, branch, "LabTechnician", doB, 30000, "123", (branch.equals("Uttara")? 1300:2300) );

                oos.writeObject(lt);
            }

        } catch (IOException ex) {

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
            }
        }
        return lt;
    }
}
