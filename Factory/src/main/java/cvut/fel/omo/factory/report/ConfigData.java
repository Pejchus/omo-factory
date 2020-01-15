package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;
import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.LineManagement;

import java.util.ArrayList;

public class ConfigData extends AbstractData{
    ArrayList<Line> lines;
    private Archive archive;
    private int level;

    public ConfigData(int level){
        this.level = level;
    }

    public void update(ArrayList<Line> lines){
        this.lines = lines;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    @Override
    protected void save(Archive archive){
        archive.addConf(this);
    }
}
