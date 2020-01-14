package cvut.fel.omo.factory.management;

import cvut.fel.omo.factory.events.EventCreator;

import java.util.ArrayList;
import java.util.Collections;

public class LineManagement {
    private ArrayList<Line> lines;
    private int activeLines;
    private ArrayList<Blueprint> all_blueprints;
    private ArrayList<Integer> outages;
    private EventCreator eventCreator;
    private Storage storage;

    public LineManagement(EventCreator e,Storage s){
        storage=s;
        lines = new ArrayList<Line>();
        activeLines = 0;
        all_blueprints = new ArrayList<Blueprint>();
        outages = new ArrayList<Integer>();
        eventCreator=e;
    }
    public void addBlueprint(Blueprint B){
        all_blueprints.add(B);
    }
    public void createLine(Blueprint blueprint, int priority, int productNum){
        Line line = new Line(blueprint,priority,productNum, eventCreator);
        lines.add(line);
    }
    public void repairDone(int serialNumber){
        for(Line line:lines) {
            for(Robot r: line.getRobots()){
                if (r.getSerialNumber()==serialNumber){
                    r.maintananceCompleted(storage);
                    return;
                }
            }for(Machine m:line.getMachines()){
                m.maintananceDone();
            }
        }
    }
    public void work(Storage storage){
        Collections.sort(this.lines);
        for(Line line:lines) {
            if (line.functionalityCheck(storage)) {
                line.work();
                this.activeLines++;
            }
        }
    }


}
