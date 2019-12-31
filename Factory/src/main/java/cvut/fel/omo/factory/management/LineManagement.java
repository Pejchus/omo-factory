package cvut.fel.omo.factory.management;

import java.util.ArrayList;

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
    public void addBlueprint(String config, String materials, int productCost, int value){
        Blueprint blueprint = new Blueprint(config,materials,productCost,value);
        all_blueprints.add(blueprint);
    }
    public void createLine(Blueprint blueprint, int priority, int productNum){
        Line line = new Line(blueprint,priority,productNum);
        lines.add(line);
    }

    public void functionalityCheck(){
        for(Line line:lines){
            if(line.functionalityCheck()){
                activeLines++;
            }
        }
    }


}
