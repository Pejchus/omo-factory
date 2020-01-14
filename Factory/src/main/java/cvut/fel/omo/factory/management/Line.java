/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.omo.factory.management;
import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.finance.Finance;

import java.util.ArrayList;
/**
 *
 * @author Štěpán
 */
public class Line implements Comparable<Line> {
    private int priority;
    private Blueprint blueprint;
    private ArrayList<Machine> machines;
    private ArrayList<Person> people;
    private ArrayList<Robot> robots;
    private int productNum;
    private int minRobot;
    private int minMachine;


    public Line(Blueprint blueprint, int priority, int productNum, EventCreator e){
        machines = new ArrayList<Machine>();
        people = new ArrayList<Person>();
        robots = new ArrayList<Robot>();
        this.priority = priority;
        this.blueprint = blueprint;
        this.productNum = productNum;
        String config = blueprint.getConfiguration();
        for(int i=0;i<config.length();i++){
            char A = config.charAt(i);
            switch(A){
                //TODO Discuss if parameters electricity and oil are needed
                case 'R':
                    Robot newRobot = new Robot(0,100,this.priority,e);
                    robots.add(newRobot);
                    break;
                case 'P':
                    Person newPerson = new Person(20000);
                    people.add(newPerson);
                    break;
                case 'M':
                    Machine newMachine = new Machine(0,this.priority,e);
                    machines.add(newMachine);
                    break;
            }
        }
    }
    public int getPriority(){return this.priority;}
    public ArrayList<Robot> getRobots(){return robots;}
    public ArrayList<Machine> getMachines(){return  machines;}

    public boolean functionalityCheck(Storage storage){
        int nonFunctionalRobots = 0;
        int functionalMachines = 0;
        for(Robot robot:this.robots){
            nonFunctionalRobots += robot.functionalityCheck(storage);
        }
        for(Machine machine:this.machines){
            functionalMachines += machine.functionalityCheck();
        }
        if(nonFunctionalRobots>0){
            if(nonFunctionalRobots>storage.numRobot()){return false;}
        }
        if(this.machines.size() != functionalMachines ){
            return false;
        }
        return true;
    }
    public int work(Finance finance){
            /*TODO work will create a product
            1) update consumption stats of robots and machines and send them to API
            3) value of product will be added to finance budget
            4) time iterates*/
            int profit=0;
            for(Robot r:robots){
                profit-=r.get_electricity();
            }
            for(Machine m:machines) {
                profit -= m.get_electricity();
            }
            profit+=blueprint.getValue();
            for (int i= 0;i<blueprint.getMaterials().length;i++){
                profit-=blueprint.getNumMaterial()[i]*finance.getMaterialCost(blueprint.getMaterials()[i]);
            }
        getRobotDiagnostics();
        getMachineDiagnostics();
        return profit;
    }
    public int payPeasants(){
        int pay=0;
        for(Person p: people){
            pay+= p.get_wage();
        }
        return pay;
    }

    @Override
    public int compareTo(Line line){
        return (Integer.compare(this.getPriority(), line.getPriority()));
    }

    public String[] getRobotDiagnostics(){
        String[] ret = new String[robots.size()];
        String oil;
        String el;
        int i = 0;
        for (Robot r : robots
             ) {
            oil = Integer.toString(r.robotApi.getOil());
            el = Integer.toString(r.robotApi.getElectricity());
            ret[i] = "Robot" + (i+1) + "'s oil level: " + oil + ", Electricity consumption: " + el;
            i++;
        }
        return ret;
    }

    public String[] getMachineDiagnostics(){
        String[] ret = new String[machines.size()];
        String oil;
        String el;
        int i = 0;
        for (Machine m : machines
        ) {
            oil = Integer.toString(m.machineApi.getOil());
            el = Integer.toString(m.machineApi.getElectricity());
            ret[i] = "Machine" + (i+1) + "'s oil level: " + oil + ", Electricity consumption: " + el;
            i++;
        }
        return ret;
    }
    public void repairDone(int serialNumber, Storage storage){
        for(Robot r:robots){
            if (r.getSerialNumber()==serialNumber){
                r.maintananceCompleted(storage);
                return;
            }
        }for(Machine m:machines){
            if (m.getSerialNumber()==serialNumber){
                m.maintananceDone();
                return;
            }
        }
    }
}
