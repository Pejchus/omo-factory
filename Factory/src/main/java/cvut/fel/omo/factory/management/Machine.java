/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.omo.factory.management;

/**
 *
 * @author Štěpán
 */
public class Machine {
    private int electricity, oil;
    private boolean functionality;
    MachineAPI machineApi;

    public Machine(int electricity){
        this.electricity = electricity;
        this.oil = 100;
        this.functionality = true;
        machineApi = new MachineAPI(this);
    }

    int get_electricity(){
        return this.electricity;
    }
    int get_oil(){
        return this.oil;
    }
    public void setFunctionality(boolean functionality){ this.functionality = functionality;}
    public boolean is_functional(){
        return this.functionality;
    }

    public int functionalityCheck(){
        if(!is_functional()){return 0;}
        if(oil<30){
            this.functionality = false;
            //TODO create event which is calling maintainter
            return 0;
        }
        return 1;
    }
}
