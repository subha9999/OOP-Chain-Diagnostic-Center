/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportingUsers;

import NonUserClass.AppendableObjectOutputStream;
import UserClass.Employee;
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
 * @author ASUS
 */
public class CleaningAndLaundryStaff extends Employee implements Serializable {

    int noOfTask;

    public CleaningAndLaundryStaff() {
    }

    public CleaningAndLaundryStaff(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public CleaningAndLaundryStaff(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
    }

    public static CleaningAndLaundryStaff addInstance(String name, int phone, String gender, String branch, LocalDate doB) {

        CleaningAndLaundryStaff c = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("CleaningAndLaundryStaff.bin");

            // File f = new File("CleaningAndLaundryStaff.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (CleaningAndLaundryStaff) ois.readObject();
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
            File f = new File("CleaningAndLaundryStaff.bin");

            // File f = new File("CleaningAndLaundryStaff.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                c = new CleaningAndLaundryStaff(phone, name, gender, branch, "Cleaning And Laundry Staff", doB, 10000, "123", temp + 1);
                oos.writeObject(c);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                c = new CleaningAndLaundryStaff(phone, name, gender, branch, "Cleaning And Laundry Staff", doB, 10000, "123", (branch.equals("Uttara") ? 1600 : 2600));

                oos.writeObject(c);
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
        return c;
    }

}
