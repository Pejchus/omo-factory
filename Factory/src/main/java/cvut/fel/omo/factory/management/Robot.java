package cvut.fel.omo.factory.management;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cvut.fel.omo.factory.events.Event;
import cvut.fel.omo.factory.events.EventCreator;

/**
 *
 * @author Štěpán
 */
public class Robot extends Destroyer{
    private int electricity;
    private int oil;
    private boolean functionality;
    private boolean replacment;
    private Robot replaceRobot;
    RobotAPI robotApi;

    public Robot(int electricity, int oil, EventCreator e){
        eventCreator =e;
        this.electricity = electricity;
        this.oil = oil;
        this.functionality = true;
        this.replacment = false;
        this.replaceRobot = null;
        robotApi = new RobotAPI(this);
    }
    
    int get_electricity(){
        return this.electricity;
    }
    int get_oil(){
        return this.oil;
    }
    void setFunctionality(boolean functionality){ this.functionality = functionality;}
    boolean is_functional(){
        return this.functionality;
    }

    public int functionalityCheck(Storage storage){

        if(!is_functional() && !this.replacment){return 1;}
        int replacementCheck = (storage.numRobot() > 0) ? 0 : 1 ;
        int result = mayDestroy(replacementCheck+1);
        oil-=(int)(3.0 * Math.random());
        if(this.oil<30){
            eventCreator.pushEvent(new Event("run out of oil",this.toString(),replacementCheck+1));
        }
        if(this.oil<30 || result == 0){
            if(storage.numRobot() > 0){
                this.replacment = true;
                this.replaceRobot = storage.getRobot();
            }
            this.functionality = false;
            return 0;
        }
        return 1;
    }

    public void maintananceCompleted(Storage storage){
        this.functionality = true;
        this.replacment = false;
        storage.returnRobot(this.replaceRobot);

    }


}
