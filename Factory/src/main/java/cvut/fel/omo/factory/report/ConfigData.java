package cvut.fel.omo.factory.report;

import cvut.fel.omo.factory.Factory;
import cvut.fel.omo.factory.management.Line;
import cvut.fel.omo.factory.management.LineManagement;

import java.util.ArrayList;

public class ConfigData extends AbstractData{
    private ArrayList<Line> lines;
    private int level;

    public ConfigData(int level){
        this.level = level;
    }

    public void update(Factory f){
        ArrayList<Line> lines = f.getLineManagement().getLines();
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
