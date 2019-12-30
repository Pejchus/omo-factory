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
}
