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

    public LineManagement(EventCreator e){
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

    public void functionalityCheck(Storage storage){
        Collections.sort(this.lines);
        for(Line line:lines) {
            if (line.functionalityCheck(storage)) {
                activeLines++;
            }
        }
    }


}
