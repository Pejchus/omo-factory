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

    public Robot(int electricity,int oil){
        this.electricity = electricity;
        this.oil = oil;
        this.functionality = true;
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

    public int functionalityCheck(){
        if(!is_functional()){return 1;}
        if(oil<30){
            this.functionality = false;
            //TODO create event which is calling maintainter
            return 1;
        }
        return 0;
    }
}
