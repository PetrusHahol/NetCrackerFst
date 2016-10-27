package com.utils;

import java.util.Scanner;

/**
 * Created by Asus on 26.10.2016.
 */
public class ExecutedUtils {


    public int tryParse(String string){
        int answer = 0;
        try {
            answer = Integer.parseInt(string);
        }catch (NumberFormatException e) {
            System.err.println("Wrong Format");
        }
        return answer;
    }

    public int handler(String type, int lowerData, int upperData){
        int result = 0;
        Scanner input = new Scanner(System.in);
        while (result == 0) {
            System.out.println("Enter  " + type + " " + lowerData + " - " + upperData);
            result  = 0;
            while (result == 0){
                result = tryParse(input.nextLine());
                if (result < lowerData || result > upperData) {
                    System.err.println("Try Again");
                    result = 0;
                }
            }
        }
        return result;
    }

}
