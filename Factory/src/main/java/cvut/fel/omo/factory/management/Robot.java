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
public class Robot extends Destroyer implements Comparable<Robot>{
    private int priority;
    private int electricity;
    private int oil;
    private boolean functionality;
    private boolean replacment;
    private Robot replaceRobot;
    RobotAPI robotApi;

    public Robot(int electricity, int oil,int priority, EventCreator e){
        this.priority = priority;
        eventCreator =e;
        this.electricity = electricity;
        this.oil = oil;
        this.functionality = true;
        this.replacment = false;
        this.replaceRobot = null;
        robotApi = new RobotAPI(this);
        serialNumber=counter;
        counter++;
    }

    public RobotAPI getAPI() { return robotApi; }
    public int get_electricity(){
        return this.electricity;
    }
    public int get_oil(){
        return this.oil;
    }
    void setFunctionality(boolean functionality){ this.functionality = functionality;}
    public boolean is_functional(){
        return this.functionality;
    }

    public int functionalityCheck(Storage storage){

        if(!is_functional() && !this.replacment){return 1;}
        int replacementCheck = (storage.numRobot() > 0) ? 0 : 1 ;
        int result = mayDestroy(replacementCheck+1);
        oil-=(int)(3.0 * Math.random());
        if(this.oil<30){
            eventCreator.pushEvent(new Event("run out of oil",Integer.toString(serialNumber),replacementCheck+1+priority));
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
        this.oil=100;
        storage.returnRobot(this.replaceRobot);

    }


    @Override
    public int compareTo(Robot robot){
        return (Integer.compare(this.get_oil(), robot.get_oil()));
    }
}
