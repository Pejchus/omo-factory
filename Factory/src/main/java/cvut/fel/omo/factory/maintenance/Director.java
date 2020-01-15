package cvut.fel.omo.factory.maintenance;

import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.LineManagement;
import cvut.fel.omo.factory.management.Machine;
import cvut.fel.omo.factory.management.Robot;

public class Director {
    private LineManagement lineManagement;


    public Director(LineManagement lineManagement){
        this.lineManagement = lineManagement;
    }

    public void visit(){
        for(Line l : lineManagement.getLines()){
            for(Robot r : l.getRobots()){
                if(!r.is_functional()){
                    System.out.println("Robot no."+r.getSerialNumber() + "is not functional\n");
                }
                else{
                    System.out.println("Robot no."+r.getSerialNumber()+"is OK");
                }
            }
            for(Machine m : l.getMachines()){
                if(!m.is_functional()){
                    System.out.println("Machine no."+m.getSerialNumber() + "is not functional\n");
                }
                else{
                    System.out.println("Machine no."+m.getSerialNumber()+"is OK");
                }
            }
        }
    }
}
