package cvut.fel.omo.factory.management;

import cvut.fel.omo.factory.events.EventCreator;
import cvut.fel.omo.factory.events.InspectorObserver;
import cvut.fel.omo.factory.events.LineObserver;
import cvut.fel.omo.factory.finance.Finance;
import cvut.fel.omo.factory.maintenance.Inspector;

import java.util.ArrayList;
import java.util.Collections;

public class LineManagement {
    private ArrayList<Line> lines;
    private int activeLines;
    private ArrayList<Blueprint> all_blueprints;
    private ArrayList<Integer> outages;
    private EventCreator eventCreator;
    private Storage storage;
    private LineObserver observer;
    private Finance finance;

    public LineManagement(EventCreator e,Storage s,Finance f){
        finance=f;
        storage=s;
        lines = new ArrayList<Line>();
        activeLines = 0;
        all_blueprints = new ArrayList<Blueprint>();
        outages = new ArrayList<Integer>();
        eventCreator=e;
        observer = new LineObserver(eventCreator,this);
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
            line.repairDone(serialNumber,storage);
        }
    }
    public void work(){
        Collections.sort(this.lines);
        for(Line line:lines) {
            finance.pay(line.payPeasants());
            if (line.functionalityCheck(storage)) {
                finance.profit(line.work(finance));
                this.activeLines++;
            }
        }
    }
    public ArrayList<Line> getLines(){
        return this.lines;
    }

}
