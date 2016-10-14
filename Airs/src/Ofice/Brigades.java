package Ofice;

import Company.Airline;
import Company.Flights;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigades  extends Airline  {
    private Pilot firstpilot;
    private Pilot secondpilot;
    private Stewardess stewardes;
    private Radiomen radiomen;
    private Navigator navigator ;
    private Flights flightObj;

    public Brigades() {
        int pos = 0;
        for (Pilot iter:Oficers.pilots)
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numb first pilot");
        int index_first_pilot = in.nextInt();

        pos = 0;
        for (Pilot iter:Oficers.pilots)
        {   pos++;
            if (pos == index_first_pilot) {
                this.firstpilot = iter;
            }
        }
        System.out.println("Enter numb second pilot");
        int index_second_pilot = in.nextInt();
        pos = 0;
        for (Pilot iter:Oficers.pilots)
        {   pos++;
            if (pos == index_second_pilot) {
                this.secondpilot = iter;
            }
        }
        pos = 0;
        for (Stewardess iter:Oficers.stewardess)
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb stewardes");
        int index_stewardes = in.nextInt();
        pos = 0;

        for (Stewardess iter:Oficers.stewardess)
        {   pos++;
            if (pos == index_stewardes) {
                this.stewardes = iter;
            }
        }

        pos = 0;
        for (Navigator iter:Oficers.navigators)
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb navigator");
        int index_navigator = in.nextInt();
        pos = 0;
        for (Navigator iter:Oficers.navigators)
        {   pos++;
            if (pos == index_navigator) {
                this.navigator = iter;
            }
        }

        pos = 0;
        for (Radiomen iter:Oficers.radiomens)
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb radiomen");
        int index_radiomen = in.nextInt();

        pos = 0;
        for (Radiomen iter:Oficers.radiomens)
        {   pos++;
            if (pos == index_radiomen) {
                this.radiomen = iter;
            }
        }
        pos = 0;
        for (Flights iter:flights )
        {   pos++;
            if (pos == index_radiomen) {
                System.out.println(Integer.toString(pos)+" "+iter+"\n");
            }
        }
        System.out.println("Enter flight index");
        int indexObj = in.nextInt();
        pos=0;
        for (Flights iter:flights )
        {   pos++;
            if (pos == indexObj) {
                flightObj = iter;
            }
        }
    }


    public String toString(){
        return ("Brigade :"+ "\t"+firstpilot + "\t"+secondpilot + "\t"+stewardes +"\t"+ navigator +"\t"+ radiomen +"\t"+ flightObj+"\n\n\n");
    }


}
