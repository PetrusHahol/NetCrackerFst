package Administrator;

import Ofice.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher  {

    public  void AddBrigade(){
        Oficers.brigade.add(new Brigades());
    }

    public  void AddNewRadioman(){
        Oficers.radiomens.add(new Radiomen());
    }

    public  void AddNewStewardess(){
        Oficers.stewardess.add(new Stewardess());
    }

    public  void AddNewNavigator(){
        Oficers.navigators.add(new Navigator());
    }

    public  void AddNewPilot(){
        Oficers.pilots.add(new Pilot());
    }

    public  void Info(){
        for (Radiomen iter:Oficers.radiomens){
            System.out.print(iter);
        }
        for (Pilot iter:Oficers.pilots){
            System.out.print(iter);
        }
        for (Navigator iter:Oficers.navigators){
            System.out.print(iter);
        }
        for (Stewardess iter:Oficers.stewardess){
            System.out.print(iter);
        }

        for (Brigades iter:Oficers.brigade){
            System.out.print(iter);
        }

    }
}
