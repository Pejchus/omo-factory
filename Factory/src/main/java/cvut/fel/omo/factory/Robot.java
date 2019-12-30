package cvut.fel.omo.factory;

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
    
    int get_electricity(){
        return this.electricity;
    }
    
    int get_oil(){
        return this.oil;
    }
    
    boolean is_functional(){
        return this.functionality;
    }
}
