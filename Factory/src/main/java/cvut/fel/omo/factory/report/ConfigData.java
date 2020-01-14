package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;
import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.LineManagement;

import java.util.ArrayList;

public class ConfigData {
    ArrayList<Line> lines;
    int tact;

    public ConfigData(LineManagement management){
        this.lines = management.getLines();
    }
}
