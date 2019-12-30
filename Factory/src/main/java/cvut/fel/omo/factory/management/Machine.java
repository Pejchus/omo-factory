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

    public boolean is_functional(){
        return this.functionality;
    }
}
