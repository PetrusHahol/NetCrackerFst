package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) {


        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Menu run = new Menu();
            oos.writeObject(run);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            System.out.println("Not Serializable ");
        }

        try {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Menu run = (Menu) oin.readObject();
            run.MainMenu();
        } catch (IOException ex) {
            System.out.println("Not DiSerializable");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not Found");
        }
    }
}
