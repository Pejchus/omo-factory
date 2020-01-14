package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.MachineAPI;
import cvut.fel.omo.factory.management.Robot;

import java.util.ArrayList;

public class LineStatData {

    int all_electricity;
    int all_oil;
    String[] electricity;
    String[] oil;
    int wages;
    ArrayList<Line> lines;
    int tact;


    public LineStatData(ConfigData data){
            this.lines = data.lines;

        for (Line l : lines) {

        }

        }
}
