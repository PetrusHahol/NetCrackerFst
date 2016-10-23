package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - New menu; 2 - Download previous menu ");
        String numbDownload = input.nextLine();
        if (numbDownload.equals("1")) {
            try {
                FileOutputStream fos = new FileOutputStream("src/temp.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Menu run = new Menu();
                oos.writeObject(run);
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                System.out.println("Not Serializable ");
            }
        }
        else if (numbDownload.equals("2")) {
            try {
                FileInputStream fis = new FileInputStream("src/temp.out");
                ObjectInputStream oin = new ObjectInputStream(fis);
                Menu run = (Menu) oin.readObject();
                run.MainMenu();
                FileOutputStream fos = new FileOutputStream("src/temp.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(run);
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                System.out.println("Run again");
            } catch (ClassNotFoundException e) {
                System.out.println("Class not Found");
            }
        }
    }
}
