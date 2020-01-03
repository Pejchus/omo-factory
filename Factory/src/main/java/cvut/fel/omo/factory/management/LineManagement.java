package cvut.fel.omo.factory.management;

import java.util.ArrayList;
import java.util.Collections;

public class LineManagement {
    private ArrayList<Line> lines;
    private int activeLines;
    private ArrayList<Blueprint> all_blueprints;
    private ArrayList<Integer> outtages;

    public LineManagement(){
        lines = new ArrayList<Line>();
        activeLines = 0;
        all_blueprints = new ArrayList<Blueprint>();
        outtages = new ArrayList<Integer>();
    }
    public void addBlueprint(Blueprint B){
        all_blueprints.add(B);
    }
    public void createLine(Blueprint blueprint, int priority, int productNum){
        Line line = new Line(blueprint,priority,productNum);
        lines.add(line);
    }

    public void functionalityCheck(){
        Collections.sort(this.lines);
        for(Line line:lines){
            if(line.functionalityCheck()){
                activeLines++;
            }
        }
    }


}
