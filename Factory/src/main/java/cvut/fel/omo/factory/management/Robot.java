package cvut.fel.omo.factory.management;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Štěpán
 */
public class Robot {
    private int electricity;
    private int oil;
    private boolean functionality;
    private boolean replacment;
    private Robot replaceRobot;

    public Robot(int electricity,int oil){
        this.electricity = electricity;
        this.oil = oil;
        this.functionality = true;
        this.replacment = false;
        this.replaceRobot = null;
        RobotAPI robotApi = new RobotAPI(this);
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
        if(this.oil<30){
            if(storage.numRobot() > 0){
                //TODO event creator
                //event_creator.maintanance(this);
                this.replacment = true;
                this.replaceRobot = storage.getRobot();
            }
            this.functionality = false;
            return 1;
        }
        return 0;
    }

    public void maintananceCompleted(Storage storage){
        this.functionality = true;
        this.replacment = false;
        storage.returnRobot(this.replaceRobot);

    }
}
