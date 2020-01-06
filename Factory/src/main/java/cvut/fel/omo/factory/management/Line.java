/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.omo.factory.management;
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

    public Line(Blueprint blueprint, int priority, int productNum){
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
                    Robot newRobot = new Robot(0,100);
                    robots.add(newRobot);
                    break;
                case 'P':
                    Person newPerson = new Person(20000);
                    people.add(newPerson);
                    break;
                case 'M':
                    Machine newMachine = new Machine(0);
                    machines.add(newMachine);
                    break;
            }
        }
    }
    public int getPriority(){return this.priority;}

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
    public void work(){
            /*TODO work will create a product
            1) update consumption stats of robots and machines and send them to API
            2) cost of product will be subtracted from finance budget*
            3) value of product will be added to finance budget
            4) time iterates*/
    }

    @Override
    public int compareTo(Line line){
        return (Integer.compare(this.getPriority(), line.getPriority()));
    }
}
