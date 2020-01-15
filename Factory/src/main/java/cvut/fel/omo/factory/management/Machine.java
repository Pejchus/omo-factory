/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.omo.factory.management;
import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;

import java.util.*;
/**
 *
 * @author Štěpán
 */
public class Machine extends Destroyer implements Comparable<Machine>{
    private int electricity, oil,priority;
    private boolean functionality;
    MachineAPI machineApi;

    public Machine(int electricity,int priority,EventCreator e){
        this.priority=priority;
        eventCreator=e;
        this.electricity = electricity;
        this.oil = 100;
        this.functionality = true;
        machineApi = new MachineAPI(this);

        serialNumber=counter;
        counter++;
    }

    public MachineAPI getAPI(){return machineApi;}
    public int get_electricity(){
        return this.electricity;
    }
    void setOil(int oil){this.oil=oil;}
    public int get_oil(){
        return this.oil;
    }
    public void setFunctionality(boolean functionality){ this.functionality = functionality;}
    public boolean is_functional(){
        return this.functionality;
    }

    public int functionalityCheck(){
        if(!is_functional()){return 0;}
        int result = mayDestroy(2);
        oil-=(int)(3.0 * Math.random());
        if(oil<30){
            eventCreator.pushEvent(new Event("run out of oil",this.toString(),2));
            result = 0;
        }
        if(result==0){this.functionality=false;}
        return result;
    }

    public void maintananceDone(){
        this.functionality =true;
    }

    @Override
    public int compareTo(Machine machine){
        return (Integer.compare(this.get_oil(), machine.get_oil()));
    }
}
