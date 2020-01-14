package cvut.fel.omo.factory.maintenance;

import java.util.*;

import cvut.fel.omo.factory.Main;
import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.LineManagement;
import cvut.fel.omo.factory.management.Machine;
import cvut.fel.omo.factory.management.Robot;

public class Inspector {
    private EventCreator eventCreator;
    private LineManagement lineManagement;
    private boolean line, robot, machine, person;

    public Inspector(EventCreator eventCreator, LineManagement lineManagement){
        this.eventCreator = eventCreator;
        this.lineManagement = lineManagement;
    }

    public void visit(){
        for(Line l : lineManagement.getLines()){
            Collections.sort(l.getMachines());
            Collections.sort(l.getRobots());

            for(Robot r : l.getRobots()){
                System.out.println("Robot no. " + r.getSerialNumber() + " has oil level: " + r.get_oil() + "\n");
            }
            for(Machine m : l.getMachines()){
                System.out.println("Machine no. " + m.getSerialNumber() + " has oil level: " + m.get_oil() + "\n");
            }
        }
    }
}
