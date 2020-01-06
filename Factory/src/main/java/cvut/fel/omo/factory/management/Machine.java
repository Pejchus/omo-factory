/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.omo.factory.management;
import java.util.*;
/**
 *
 * @author Štěpán
 */
public class Machine extends Destroyer {
    private int electricity, oil;
    private boolean functionality;

    public Machine(int electricity){
        this.electricity = electricity;
        this.oil = 100;
        this.functionality = true;
    }

    public int get_electricity(){
        return this.electricity;
    }
    public int get_oil(){
        return this.oil;
    }
    public void setFunctionality(boolean functionality){ this.functionality = functionality;}
    public boolean is_functional(){
        return this.functionality;
    }

    public int functionalityCheck(){
        if(!is_functional()){return 0;}
        int result = mayDestroy();
        oil-=(int)(3.0 * Math.random());
        if(oil<30){
            //TODO create event which is calling maintainter
            result = 0;
        }
        if(result==0){this.functionality=false;}
        return result;
    }

}
