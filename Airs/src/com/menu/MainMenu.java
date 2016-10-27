package com.menu;

import com.utils.ExecutedUtils;

import java.util.Scanner;

/**
 * Created by Asus on 27.10.2016.
 */
public class MainMenu {

    public MainMenu(){
        int tmp = 0;
        Scanner input = new Scanner(System.in);
        ExecutedUtils utility = new ExecutedUtils();
        AdminMenu adminMenu = new AdminMenu();
        DispatcherMenu dispatcherMenu = new DispatcherMenu();

        while (tmp != -1) {
            System.out.println("Enter number:\n1 "
                    +"- Go to administrator center\n"
                    +"2 - Go to Dispatcher center\n-1 - Exit");
            tmp = utility.tryParse(input.nextLine());
            switch (tmp) {
                case 1:
                    adminMenu.main();
                    break;
                case 2:
                    dispatcherMenu.main(adminMenu.getAdmin());
                    break;
            }
        }
    }
}
