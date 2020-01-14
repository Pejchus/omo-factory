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
public class Person {
    private int wage;

    public Person(int wage){
        this.wage = wage;
    }
    public int get_wage(){
        return this.wage;
    }

    public void set_wage(int wage){
        this.wage = wage;
    }


}

